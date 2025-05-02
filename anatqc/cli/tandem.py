import os
import re
import sys
import json
import yaml
import yaxil
import logging
import yaxil.bids
import argparse as ap
import subprocess as sp
import anatqc.cli.get
import anatqc.cli.process
import collections as col
import yaxil.bids

logger = logging.getLogger(__name__)

def do(args):
    if args.insecure:
        logger.warning('disabling ssl certificate verification')
        yaxil.CHECK_CERTIFICATE = False

    # load authentication data and set environment variables for ArcGet.py
    auth = yaxil.auth2(
        args.xnat_alias,
        args.xnat_host,
        args.xnat_user,
        args.xnat_pass
    )
    os.environ['XNAT_HOST'] = auth.url
    os.environ['XNAT_USER'] = auth.username
    os.environ['XNAT_PASS'] = auth.password

    conf = yaml.safe_load(open(args.config))

    # query T1w and vNav scans from XNAT
    with yaxil.session(auth) as ses:
        scans = col.defaultdict(dict)
        for scan in ses.scans(label=args.label, project=args.project):
            note = scan['note']
            move_match = match(note, conf['anatqc']['tags']['vnav'])
            anat_match = match(note, conf['anatqc']['tags']['t1w'])
            if move_match:
                run = move_match.group('run')
                run = re.sub('[^0-9]', '', run or '1')
                if int(run) == int(args.run):
                    scans[run]['move'] = scan['id']
            if anat_match:
                run = anat_match.group('run')
                run = re.sub('[^0-9]', '', run or '1')
                if int(run) == int(args.run):
                    scans[run]['anat'] = scan['id']
    subject_label = scan['subject_label']

    logger.info(json.dumps(scans, indent=2))

    for run,scansr in scans.items():
        if 'anat' in scansr:
            logger.info('getting anat run=%s, scan=%s', run, scansr['anat'])
            anatqc.cli.get.get_anat(args, auth, run, scansr['anat'], verbose=args.verbose)
        if 'move' in scansr:
            logger.info('getting move run=%s, scan=%s', run, scansr['move'])
            anatqc.cli.get.get_move(args, auth, run, scansr['move'], verbose=args.verbose)
        args.run = int(run)
        bids_ses_label = yaxil.bids.legal.sub('', args.label)
        bids_sub_label = yaxil.bids.legal.sub('', subject_label)
        args.sub = 'sub-' + bids_sub_label
        args.ses = 'ses-' + bids_ses_label
        logger.debug('sub=%s, ses=%s', args.sub, args.ses)
        anatqc.cli.process.do(args)

def match(note, patterns):
    for pattern in patterns:
        m = re.match(pattern, note, flags=re.IGNORECASE)
        if m:
            return m
    return None

