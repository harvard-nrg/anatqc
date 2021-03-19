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
    # query "MOVE_\d+" and "ANAT_\d+" into a dictionary
    auth = get_auth(args)
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

def getauth(args):
    # First, look for ~/.xnat_auth using --xnat-alias
    if args.xnat_alias:
        logger.debug('returning authentication data from authentication file')
        return yaxil.auth(args.xnat_alias)
    # Second, look for authentication data from the command line
    authargs = (args.xnat_host, args.xnat_user, args.xnat_pass)
    if any(authargs):
        if not all(authargs):
            logger.critical('you must supply --xnat-host, --xnat-user, and --xnat-pass')
            sys.exit(1)
        logger.debug('returning authentication data from command line')
        return yaxil.XnatAuth(url=args.xnat_host, username=args.xnat_user, password=args.xnat_pass)
    # Third, look for authentication data in environment variables
    xnat_host = os.environ.get('XNAT_HOST', None)
    xnat_user = os.environ.get('XNAT_USER', None)
    xnat_pass = os.environ.get('XNAT_PASS', None)
    authargs = (xnat_host, xnat_user, xnat_pass)
    if any(authargs):
        if not all(authargs):
            logger.critical('you must set $XNAT_HOST, $XNAT_USER, and $XNAT_PASS environment variables')
            sys.exit(1)
        logger.debug('returning authentication data from user environment')
        return yaxil.XnatAuth(url=xnat_host, username=xnat_user, password=xnat_pass)

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

