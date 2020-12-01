import os
import shutil
import logging
from anatqc.bids import BIDS
import anatqc.tasks as tasks
from executors.models import Job

logger = logging.getLogger(__name__)

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
        if self._pipenv:
            os.chdir(self._pipenv)
            cmd[:0] = ['pipenv', 'run']
        cmd.extend(steps)
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

