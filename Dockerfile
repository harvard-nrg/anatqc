FROM centos:8

# install useful (but not entirely necessary) things
RUN dnf install -y git vim

# install some things
RUN dnf install -y python3 python3-devel

# set python to python3
RUN alternatives --set python /usr/bin/python3

# install pipenv
RUN pip3 install pipenv

# install freesurfer
ARG FS_PREFIX=/sw/apps/freesurfer/
ARG FS_URI="https://www.dropbox.com/s/bzpqywglrhommfw/freesurfer-Linux-centos6_x86_64-stable-pub-v6.0.1.tar.gz?dl=0"
RUN mkdir -p ${FS_PREFIX}
RUN curl -L -s "${FS_URI}" | tar -C "${FS_PREFIX}" -xzf - \
  --strip-components=1 \
  --exclude="freesurfer/diffusion" \
  --exclude="freesurfer/docs" \
  --exclude="freesurfer/fsfast" \
  --exclude="freesurfer/lib/cuda" \
  --exclude="freesurfer/matlab" \
  --exclude="freesurfer/mni/share/man" \
  --exclude="freesurfer/subjects/fsaverage_sym" \
  --exclude="freesurfer/subjects/fsaverage3" \
  --exclude="freesurfer/subjects/fsaverage4" \
  --exclude="freesurfer/subjects/cvs_avg35" \
  --exclude="freesurfer/subjects/cvs_avg35_inMNI152" \
  --exclude="freesurfer/subjects/bert" \
  --exclude="freesurfer/subjects/lh.EC_average" \
  --exclude="freesurfer/subjects/rh.EC_average" \
  --exclude="freesurfer/subjects/sample-*.mgz" \
  --exclude="freesurfer/subjects/V1_average" \
  --exclude="freesurfer/trctrain"
RUN dnf install -y tcsh libgomp bc mesa-libGLU libXmu
RUN dnf install -y epel-release
RUN dnf install -y \
  libpng12 perl perl-core ImageMagick glx-utils \
  mesa-libGL mesa-libGLU-devel mesa-libGL-devel \
  mesa-dri-drivers libXmu libXmu-devel libX11 \
  libX11-devel libXt-devel xorg-x11-server-Xorg \
  xorg-x11-server-Xvfb mesa-libxatracker xorg-x11-drivers \
  xorg-x11-drv-vmware libXScrnSaver dbus GConf2

# install mriqc into an isolated pipenv environment
ARG MRIQC_VERSION="0.15.3"
ARG MRIQC_PREFIX="/sw/apps/mriqc"
ARG MRIQC_URI="git+https://github.com/poldracklab/mriqc.git@${MRIQC_VERSION}#egg=mriqc"
RUN dnf groupinstall -y "Development Tools"
RUN dnf install -y xorg-x11-server-Xvfb 
RUN mkdir -p "${MRIQC_PREFIX}"
ENV PIPENV_VENV_IN_PROJECT=1
WORKDIR "${MRIQC_PREFIX}"
RUN pipenv install --skip-lock \
  "dipy" \
  "jinja2" \
  "matplotlib==2.2.2" \
  "nibabel>=3.0.1,<4.0" \
  "nilearn==0.7.1" \
  "nipype~=1.4" \
  "nitime" \
  "niworkflows~=1.1" \
  "numpy==1.15.4" \
  "pandas==0.23.4" \
  "pybids>=0.10.2" \
  "PyYAML" \
  "scikit-learn==0.19.1" \
  "scipy==1.1.0" \
  "seaborn" \
  "statsmodels" \
  "svgutils==0.3.1" \
  "templateflow>=0.5.2" \
  "toml" \
  "traits==4.6.0" \
  "xvfbwrapper"
RUN pipenv install --skip-lock "${MRIQC_URI}"
# matplotlib post setup: precache fonts and change backend to Agg
RUN sed -i 's/\(backend *: \).*$/\1Agg/g' "$(pipenv run python -c 'import matplotlib; print(matplotlib.matplotlib_fname())')"
# templateflow post setup: cache templates
RUN pipenv run python -c "from templateflow import api as tfapi; \
  tfapi.get('MNI152NLin2009cAsym', resolution=[1, 2], suffix='T1w', desc=None); \
  tfapi.get('MNI152NLin2009cAsym', resolution=[1, 2], suffix='mask', desc=['brain', 'head']); \
  tfapi.get('MNI152NLin2009cAsym', resolution=1, suffix='dseg', desc='carpet'); \
  tfapi.get('MNI152NLin2009cAsym', resolution=1, suffix='probseg', label=['CSF', 'GM', 'WM']); \
  tfapi.get('MNI152NLin2009cAsym', resolution=[1, 2], suffix='boldref')"

# install fsl
ARG FSL_PREFIX="/sw/apps/fsl/"
ARG FSL_URI="https://www.dropbox.com/s/p8go1t8kcoe41pz/fsl-6.0.4-centos7_64.tar.gz?dl=0"
RUN dnf install -y libquadmath
RUN mkdir -p "${FSL_PREFIX}"
RUN curl -L -s "${FSL_URI}" | tar -C "${FSL_PREFIX}" -xzf - \
  --strip-components=1

# install afni
ARG AFNI_PREFIX="/sw/apps/afni"
ARG AFNI_URI="https://afni.nimh.nih.gov/pub/dist/bin/misc/@update.afni.binaries"
RUN dnf install -y epel-release
RUN dnf install -y curl tcsh python2-devel libpng15 motif
RUN mkdir -p "${AFNI_PREFIX}"
WORKDIR "${AFNI_PREFIX}"
RUN curl -O "${AFNI_URI}"
RUN tcsh @update.afni.binaries -package linux_centos_7_64 -do_extras -bindir "${AFNI_PREFIX}"

# install ants
ARG ANTS_PREFIX="/sw/apps/ants"
ARG ANTS_URI="https://dl.dropbox.com/s/2f4sui1z6lcgyek/ANTs-Linux-centos5_x86_64-v2.2.0-0740f91.tar.gz"
RUN dnf install -y libGLw libGLU gsl
RUN ln -s /usr/lib64/libgsl.so.23 /usr/lib64/libgsl.so.0
RUN mkdir -p "${ANTS_PREFIX}"
RUN curl -sSL "${ANTS_URI}" \
  | tar -xzC "${ANTS_PREFIX}" --strip-components 1

# install dcm2niix
ARG D2N_PREFIX="/sw/apps/dcm2niix"
ARG D2N_URI="https://github.com/rordenlab/dcm2niix/releases/download/v1.0.20200331/dcm2niix_lnx.zip"
RUN dnf install -y unzip
RUN mkdir -p "${D2N_PREFIX}"
RUN curl -sL "${D2N_URI}" -o "/tmp/dcm2niix_lnx.zip"
WORKDIR "${D2N_PREFIX}"
RUN unzip "/tmp/dcm2niix_lnx.zip"
RUN rm "/tmp/dcm2niix_lnx.zip"

# install anatqc
ARG AQC_PREFIX="/sw/apps/anatqc"
ARG AQC_VERSION="0.4.2"
RUN dnf install -y compat-openssl10
RUN mkdir -p "${AQC_PREFIX}"
ENV PIPENV_VENV_IN_PROJECT=1
WORKDIR "${AQC_PREFIX}"
RUN pipenv install anatqc=="${AQC_VERSION}"

# freesurfer environment
ENV FREESURFER_HOME="${FS_PREFIX}"
ENV OS="Linux" \
    FS_OVERRIDE=0 \
    FIX_VERTEX_AREA="" \
    FSF_OUTPUT_FORMAT="nii.gz" \
    FREESURFER_HOME="${FREESURFER_HOME}" \
    SUBJECTS_DIR="${FREESURFER_HOME}/subjects" \
    FUNCTIONALS_DIR="${FREESURFER_HOME}/sessions" \
    MNI_DIR="${FREESURFER_HOME}/mni" \
    LOCAL_DIR="${FREESURFER_HOME}/local" \
    MINC_BIN_DIR="${FREESURFER_HOME}/mni/bin" \
    MINC_LIB_DIR="${FREESURFER_HOME}/mni/lib" \
    MNI_DATAPATH="${FREESURFER_HOME}/mni/data"
ENV PERL5LIB="${MINC_LIB_DIR}/perl5/5.8.5" \
    MNI_PERL5LIB="${MINC_LIB_DIR}/perl5/5.8.5"
ENV PATH="${FREESURFER_HOME}/bin:${FSFAST_HOME}/bin:${FREESURFER_HOME}/tktools:${MINC_BIN_DIR}:${PATH}"

# fsl environment
ENV FSLDIR="${FSL_PREFIX}"
ENV FSLGECUDAQ="cuda.q" \
    FSLMULTIFILEQUIT="TRUE" \
    FSLOUTPUTTYPE="NIFTI_GZ" \
    FSLWISH="${FSLDIR}/bin/fslwish" \
    FSLTCLSH="${FSLDIR}/bin/fsltclsh" \
    FSLMACHINELIST="" \
    FSLREMOTECALL="" \
    FSLLOCKDIR=""
ENV PATH="${FSLDIR}/bin:${PATH}"

# afni environment
ENV PATH="${AFNI_PREFIX}:${PATH}"

# ants environment
ENV PATH="${ANTS_PREFIX}:${PATH}"

# dcm2niix environment
ENV PATH="${D2N_PREFIX}:${PATH}"

# configure entrypoint
WORKDIR /sw/apps/anatqc
ENTRYPOINT ["pipenv", "run", "anatQC.py"]
