import os
import re
import sys
import json
import yaml
import glob
import math
import logging
import executors
import tempfile as tf
import subprocess as sp
from anatqc.bids import BIDS
from executors.models import Job, JobArray
import anatqc.tasks.mriqc as mriqc
import anatqc.tasks.vnav as vnav
import anatqc.tasks.morph as morph
from anatqc.state import State

logger = logging.getLogger(__name__)

def do(args):
    # create job executor and job array
    if args.scheduler:
        E = executors.get(args.scheduler, partition=args.partition)
    else:
        E = executors.probe(args.partition)
    jarray = JobArray(E)

    # create BIDS
    B = BIDS(args.bids_dir, args.sub, ses=args.ses)
    raw = B.raw_anat('T1w', run=args.run)
    source = B.raw_anat('T1vnav', run=args.run, sourcedata=True)
    logger.debug('T1w raw: %s', raw)
    logger.debug('T1vnav sourcedata: %s', source)

    # get T1w repetition time from BIDS sidecar for vNav
    sidecar = os.path.join(*raw) + '.json'
    with open(sidecar) as fo:
        js = json.load(fo)
        tr = js['RepetitionTime']

    # morph job
    if 'morph' in args.sub_tasks:
        infile = os.path.join(*raw) + '.nii.gz'
        outdir = B.derivatives_dir('anatqc-morph')
        outdir = os.path.join(outdir, 'anat', raw[1])
        task = morph.Task(
            infile,
            outdir
        )
        logger.info(json.dumps(task.command, indent=1))
        jarray.add(task.job)

    # vnav job
    if 'vnav' in args.sub_tasks:
        indir = os.path.join(*source) + '.dicom'
        outdir = B.derivatives_dir('anatqc-vnav')
        outdir = os.path.join(outdir, 'anat', source[1])
        task = vnav.Task(
            indir,
            outdir,
            tr
        )
        logger.info(json.dumps(task.command, indent=1))
        jarray.add(task.job)

    # mriqc job
    if 'mriqc' in args.sub_tasks:
        outdir = B.derivatives_dir('anatqc-mriqc')
        outdir = os.path.join(outdir, 'anat', raw[1])
        task = mriqc.Task(
            sub=args.sub,
            ses=args.ses,
            run=args.run,
            bids=args.bids_dir,
            outdir=outdir,
            tempdir='/scratch',
            pipenv='/sw/apps/mriqc'
        )
        logger.info(json.dumps(task.command, indent=1))
        jarray.add(task.job)

    # submit jobs and wait for them to finish
    if not args.dry_run:
        logger.info('submitting jobs')
        jarray.submit(limit=args.rate_limit)
        logger.info('waiting for all jobs to finish')
        jarray.wait()
        numjobs = len(jarray.array)
        failed = len(jarray.failed)
        complete = len(jarray.complete)
        if failed:
            logger.info('%s/%s jobs failed', failed, numjobs)
        logger.info('%s/%s jobs completed', complete, numjobs)
        if failed > 0:
            sys.exit(1)
