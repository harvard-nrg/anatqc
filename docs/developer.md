# Developer Guide

## Dependencies
AnatQC is built upon [FreeSurfer][], [MRIQC][], and [volumetric
navigators][vNav] software packages. The [container][Container] is based on Rocky
Linux.

| Package         | Version   | Download                              |
|-----------------|-----------|---------------------------------------|
| [Rocky Linux][] | `8`       | [:material-download:][Rocky Linux DL] |
| [FreeSurfer][]  | `6.0.0`   | [:material-download:][FreeSurfer DL]  |
| [MRIQC][]       | `0.15.3`  | [:material-download:][MRIQC DL]       |
| [vNav][]        | `0.4.0`   | [:material-download:][vNav DL]        |

## Pipeline overview
### FreeSurfer
FreeSurfer is a full processing stream for MRI imaging data that implements
anatomical segmentation, cortical surface reconstruction, registration, and
parcellation.

#### `recon-all`
AnatQC runs the main FreeSurfer reconstruction pipeline, `recon-all`, on a 
single `T1w` image

!!! note "Submilimeter resolution"
    If the input image is submilimeter resolution, the `-hires` argument will
    be appended to the `recon-all` command.
```bash
recon-all -sd ${SUBJECTS_DIR} -s ${SUBJECT} -all -i ${NIFTI}
```
#### `tal_QC_AZS`
The `tal_QC_AZS` command outputs a quality control metric that reflects the 
accuracy of the Talairach transformation during the `-tal-check` stage of 
`recon-all`

```bash
tal_QC_AZS talairach_avi.log
```

#### `mris_anatomical_stats`
The `mris_anatomical_stats` command outputs metrics such as surface area, gray 
matter volume, and cortical thickness for a particular hemisphere

```bash
mris_anatomical_stats -l lh.cortex.label ${SUBJECT} lh
mris_anatomical_stats -l rh.cortex.label ${SUBJECT} rh
```

#### `mris_euler_number`
The `mris_euler_number` command produces a quality control metric that reflects 
the number of surface defects in the *unfixed* surfaces. A perfectly 
reconstructed cortical hemisphere surface should be topologically equivalent to 
a sphere, which should have an expected Euler number of `2`. Deviations from 
this number indicate the presence of topological defects, such as "holes" or 
self-intersecting "handles"

```bash
mris_euler_number lh.orig.nofix
mris_euler_number rh.orig.nofix
```

#### `wm-anat-snr`
The `wm-anat-snr` command calculates the White Matter anatomical Signal-to-Noise
Ratio from a subject's structural image. This metric may be used to identify
scans that are affected by excessive head motion, or poor tissue contrast

```bash
wm-anat-snr --sd ${SUBJECT} --force
```

#### `mri_cnr`
While `wm-anat-snr` checks noise level *within* a single tissue (White Matter),
`mri_cnr` measures Contrast-to-Noise Ratio. This metric reflects how well 
separated signal intensities are *between* adjacent tissues. 

```bash
mri_cnr ${SUBJECTS_DIR}/${SUBJECT}/surf ${SUBJECTS_DIR/${SUBJECT}/mri/orig.mgz
```

### MRIQC
[MRIQC][] is a well-known tool designed to automate quality control and 
extraction of image quality metrics from MRI brain images. MRIQC generates an
HTML report that contains mosaic views of the brain, segmentaion boundaries, 
and more.

#### `mriqc`
AnatQC runs the main `mriqc` command at the `participant` level

```bash
mriqc --participant_label ${SUBJECT} --session-id ${SESSION} --run-id ${RUN}
--work-dir ${WORKING_DIR} --verbose-reports --float32 --n_procs 2 --no-sub
${INPUT_DIR} ${OUTPUT_DIR} participant
```

### vNav
[Volumetric navigators][vNav], or "vNavs", are rapid, low-resolution 3D volume 
scans slotted into the natural pauses within a longer T1-weighted structural 
MRI sequence (like MPRAGE). These navigator volumes are used to track and 
correct for head motion, in real time, without needing additional hardware.

#### `parse_vNav_Motion.py`
The `parse_vNav_Motion.py` command extracts vNav tracking data from the metadata
(DICOM headers) of T1- and T2-weighted MRI data, and generates useful head 
motion metrics and plots. These motion metrics and plots reflect milimeter 
shifts (RMS and Max) over the timeline of the sequence

```bash
parse_vNav_Motion.py --tr ${TR} --rms --max --plot --input-dir ${DICOM_DIR} --output-dir ${OUTPUT_DIR}
```

[FreeSurfer]: https://surfer.nmr.mgh.harvard.edu/
[FreeSurfer DL]: https://github.com/freesurfer/freesurfer/releases/tag/v6.0.0
[MRIQC]: https://mriqc.readthedocs.io/en/latest/
[MRIQC DL]: https://github.com/nipreps/mriqc/releases/0.15.3/
[vNav]: https://github.com/harvard-nrg/vnav
[vNav DL]: https://pypi.org/project/vnav/0.4.0/
[Rocky Linux]: https://rockylinux.org/
[Rocky Linux DL]: https://hub.docker.com/layers/library/rockylinux/8
[Container]: ../admin/#downloading-the-container
