import os
import shutil
import base64
import logging
from anatqc.bids import BIDS
import anatqc.tasks as tasks
from executors.models import Job

logger = logging.getLogger(__name__)

def make_fs_license(blob, destination=None):
    '''
    Check for FreeSurfer license and create one from
    base64 encoded blob if one does not exist

    :param blob: Base64 encoded license text
    :type blob: str
    :param destination: Destination for license file
    :type destination: str
    '''
    if not destination:
        fshome = os.environ['FREESURFER_HOME']
        destination = os.path.join(fshome, 'license.txt')
    destination = os.path.abspath(os.path.expanduser(destination))
    if not os.path.exists(destination):
        os.makedirs(os.path.dirname(destination), exist_ok=True)
        if not blob:
            raise FsLicenseError('you must provide a --fs-license')
        data = base64.b64decode(blob)
        logger.debug('writing file %s', destination)
        with open(destination, 'wb') as fo:
            fo.write(data)
    os.environ['FS_LICENSE'] = destination

class FsLicenseError(Exception):
    pass

class Task(tasks.BaseTask):
    def __init__(self, infile, outdir, tempdir=None, pipenv=None):
        self._infile = infile
        super().__init__(outdir, tempdir, pipenv)

    def build(self):
        steps = [
            'sourcedata',
            'convert',
            'recon',
            'tal_qc',
            'stats',
            'euler',
            'wm-anat-snr',
            'cnr',
            'pctsurfcon',
            'parse',
            'snapshots',
            'plots',
            'reports'
        ]
        cmd = [
            'selfie',
            '--lock',
            '--output-file', self._prov,
            'surpher.py',
            '--input', self._infile,
            '--output-dir', self._outdir,
            '--debug',
            '--steps'
        ]
        cmd.extend(steps)
        if self._tempdir:
            cmd.extend([
                '--scratch-dir', self._tempdir
            ])
        if self._pipenv:
            os.chdir(self._pipenv)
            cmd[:0] = ['pipenv', 'run']
        logdir = self.logdir()
        # copy json sidecar into output logs directory
        sidecar = BIDS.sidecar_for_image(self._infile)
        destination = os.path.join(logdir, os.path.basename(sidecar))
        logger.debug('copying %s to %s', sidecar, destination)
        shutil.copy2(sidecar, destination)
        # return job object
        log = os.path.join(logdir, 'anatqc-morph.log')
        self.job = Job(
            name='anatqc-morph',
            time='1440',
            memory='3G',
            command=cmd,
            output=log,
            error=log
        )

