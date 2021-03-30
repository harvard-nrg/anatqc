import os
import re
import sys
import json
import yaml
import yaxil
import logging
import argparse as ap
import subprocess as sp
import collections as col

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
                scans[run]['move'] = scan['id']
            if re_anat:
                run = re_anat.group(1)
                scans[run]['anat'] = scan['id']
    logger.info(json.dumps(scans, indent=2))

    for run,scansr in scans.items():
        if 'anat' in scansr:
            logger.info('getting anat run=%s, scan=%s', run, scansr['anat'])
            get_anat(args, auth, run, scansr['anat'], verbose=args.verbose)
        if 'move' in scansr:
            logger.info('getting move run=%s, scan=%s', run, scansr['move'])
            get_move(args, auth, run, scansr['move'], verbose=args.verbose)

def get_move(args, auth, run, scan, verbose=False):
    config = {
        'anat': {
            'T1vnav': [
                {
                    'run': int(run),
                    'scan': scan
                }
            ]
        }
    }
    config = yaml.safe_dump(config)
    cmd = [
        'ArcGet.py',
        '--label', args.label,
        '--output-dir', args.bids_dir,
        '--output-format', 'bids',
    ]
    if args.project:
        cmd.extend([
            '--project', args.project
        ])
    cmd.extend([
        '--config', '-'
    ])
    if verbose:
        cmd.append('--debug')
    logger.info(sp.list2cmdline(cmd))
    if not args.dry_run:
        sp.check_output(cmd, input=config.encode('utf-8'))
 
def get_anat(args, auth, run, scan, verbose=False):
    config = {
        'anat': {
            'T1w': [
                {
                    'run': int(run),
                    'scan': scan
                }
            ]
        }
    }
    config = yaml.safe_dump(config)
    cmd = [
        'ArcGet.py',
        '--label', args.label,
        '--output-dir', args.bids_dir,
        '--output-format', 'bids',
    ]
    if args.project:
        cmd.extend([
            '--project', args.project
        ])
    cmd.extend([
        '--config', '-'
    ])
    if verbose:
        cmd.append('--debug')
    logger.info(sp.list2cmdline(cmd))
    if not args.dry_run:
        sp.check_output(cmd, input=config.encode('utf-8'))

