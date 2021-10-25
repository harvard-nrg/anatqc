import os
import re
import sys
import json
import yaml
import yaxil
import glob
import math
import anatqc
import logging
import tarfile
import executors
import tempfile
import subprocess as sp
from executors.models import Job, JobArray
from anatqc.bids import BIDS
from anatqc.xnat import Report
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

    # get repetition time from T1w sidecar for vNav processing
    sidecar = os.path.join(*raw) + '.json'
    with open(sidecar) as fo:
        js = json.load(fo)
        tr = js['RepetitionTime']

    # morph job
    morph_outdir = None
    if 'morph' in args.sub_tasks:
        infile = os.path.join(*raw) + '.nii.gz'
        morph_outdir = B.derivatives_dir('anatqc-morph')
        morph_outdir = os.path.join(morph_outdir, 'anat', raw[1])
        destination = os.path.join(morph_outdir, '.license')
        morph.make_fs_license(args.fs_license, destination)
        if args.mock_fs:
            dirname = os.path.dirname(morph.__file__)
            tar = os.path.join(dirname, 'fs-mock.tar.gz')
            logger.info('extracting mock fs data %s to %s', tar, morph_outdir)
            os.makedirs(morph_outdir, exist_ok=True)
            with tarfile.open(tar) as tf:
                tf.extractall(morph_outdir)
        else:
            task = morph.Task(
                infile,
                morph_outdir
            )
            logger.info(json.dumps(task.command, indent=1))
            jarray.add(task.job)

    # vnav job
    vnav_outdir = None
    if 'vnav' in args.sub_tasks:
        indir = os.path.join(*source) + '.dicom'
        vnav_outdir = B.derivatives_dir('anatqc-vnav')
        vnav_outdir = os.path.join(vnav_outdir, 'anat', source[1])
        task = vnav.Task(
            indir,
            vnav_outdir,
            tr
        )
        if task.job:
            logger.info(json.dumps(task.command, indent=1))
            jarray.add(task.job)

    # mriqc job
    mriqc_outdir = None
    if 'mriqc' in args.sub_tasks:
        mriqc_outdir = B.derivatives_dir('anatqc-mriqc')
        mriqc_outdir = os.path.join(mriqc_outdir, 'anat', raw[1])
        task = mriqc.Task(
            sub=args.sub,
            ses=args.ses,
            run=args.run,
            bids=args.bids_dir,
            outdir=mriqc_outdir,
            tempdir=tempfile.gettempdir(),
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
            for pid,job in iter(jarray.failed.items()):
                logger.error('%s exited with returncode %s', job.name, job.returncode)
                with open(job.output, 'r') as fp:
                    logger.error('standard output\n%s', fp.read())
                with open(job.error, 'r') as fp:
                    logger.error('standard error\n%s', fp.read())
        logger.info('%s/%s jobs completed', complete, numjobs)
        if failed > 0:
            sys.exit(1)

    # create archive of FreeSurfer results
    if 'morph' in args.sub_tasks:
        archive = os.path.join(morph_outdir, 'archive.tar.gz')
        if not os.path.exists(archive):
            logger.info('creating anat-morph archive %s', archive)
            anatqc.archive(morph_outdir, archive)

    # build data to upload to xnat
    R = Report(args.bids_dir, args.sub, args.ses, args.run)
    logger.info('building xnat artifacts to %s', args.artifacts_dir)
    R.build_assessment(args.artifacts_dir)

    # upload data to xnat over rest api
    if args.xnat_upload:
        logger.info('Uploading artifacts to XNAT')
        auth = yaxil.auth2(args.xnat_alias)
        yaxil.storerest(auth, args.artifacts_dir, 'anatqc-resource')

