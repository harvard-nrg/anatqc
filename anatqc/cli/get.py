import os
import re
import json
import yaml
import yaxil
import logging
import argparse as ap
import subprocess as sp
import collections as col

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
                scans[run]['move'] = scan['id']
            if re_anat:
                run = re_anat.group(1)
                scans[run]['anat'] = scan['id']
    logger.info(json.dumps(scans, indent=2))

    for run,scansr in scans.items():
        if 'anat' in scansr:
            logger.info('getting anat run=%s, scan=%s', run, scansr['anat'])
            get_anat(args, run, scansr['anat'], verbose=args.verbose)
        if 'move' in scansr:
            logger.info('getting move run=%s, scan=%s', run, scansr['move'])
            get_move(args, run, scansr['move'], verbose=args.verbose)

def get_move(args, run, scan, verbose=False):
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
        '--alias', args.alias,
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
    output = sp.check_output(cmd, input=config.encode('utf-8'))
 
def get_anat(args, run, scan, verbose=False):
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
        '--alias', args.alias,
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
    output = sp.check_output(cmd, input=config.encode('utf-8'))

