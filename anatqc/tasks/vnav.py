import os
import json
import shutil
import logging
import tempfile as tf
import anatqc.tasks as tasks
from anatqc.state import State
from executors.models import Job
from anatqc.bids import BIDS

logger = logging.getLogger(__name__)

class Task(tasks.BaseTask):
    def __init__(self, infile, outdir, tr, tempdir=None, pipenv=None):
        self._infile = infile
        self._tr = tr
        self.job = None
        super().__init__(outdir, tempdir, pipenv)

    def build(self):
        cmd = [
            'selfie',
            '--lock',
            '--output-file', self._prov,
            'parse_vNav_Motion.py',
            '--input-dir', self._infile,
            '--tr', str(self._tr),
            '--rms',
            '--max',
            '--plot',
            '--output-dir', self._outdir
        ]
        if self._pipenv:
            os.chdir(self._pipenv)
            cmd[:0] = ['pipenv', 'run']
        # copy json sidecar into output logs directory
        image = self._infile.replace('sourcedata', '')
        sidecar = BIDS.sidecar_for_image(image)
        sidecar = sidecar.replace('_T1vnav', '_split-1_T1vnav')
        if not os.path.exists(sidecar):
            logger.debug('file not found %s', sidecar)
            return
        logdir = self.logdir()
        destination = os.path.join(logdir, os.path.basename(sidecar))
        logger.debug('copying %s to %s', sidecar, destination)
        shutil.copy2(sidecar, destination)
        # return job object
        logfile = os.path.join(logdir, 'anatqc-vnav.log')
        self.job = Job(
            name='anatqc-vnav',
            time='10',
            memory='1G',
            command=cmd,
            output=logfile,
            error=logfile
        )

