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
    # query "MOVE_\d+" and "ANAT_\d+" into a dictionary
    auth = yaxil.auth(args.alias)
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

    logger.info(json.dumps(scans, indent=2))

    for run,scansr in scans.items():
        if 'anat' in scansr:
            logger.info('getting anat run=%s, scan=%s', run, scansr['anat'])
            anatqc.cli.get.get_anat(args, run, scansr['anat'], verbose=args.verbose)
        if 'move' in scansr:
            logger.info('getting move run=%s, scan=%s', run, scansr['move'])
            anatqc.cli.get.get_move(args, run, scansr['move'], verbose=args.verbose)
        args.run = int(run)
        bids_label = yaxil.bids.legal.sub('', args.label)
        args.sub = 'sub-' + bids_label.replace('MR1', '')
        args.ses = 'ses-' + bids_label
        logger.debug('sub=%s, ses=%s', args.sub, args.ses)
        anatqc.cli.process.do(args)

