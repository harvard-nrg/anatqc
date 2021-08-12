import os
import re
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
    # query "MOVE_\d+" and "ANAT_\d+" into a dictionary
    with yaxil.session(auth) as ses:
        scans = col.defaultdict(dict)
        for scan in ses.scans(label=args.label, project=args.project):
            note = scan['note']
            re_move = re.match('MOVE_(\d+)', note)
            re_anat = re.match('ANAT_(\d+)', note)
            if re_move:
                run = re_move.group(1)
                if int(run) == int(args.run):
                    scans[run]['move'] = scan['id']
            if re_anat:
                run = re_anat.group(1)
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

