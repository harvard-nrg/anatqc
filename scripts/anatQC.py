#!/usr/bin/env python

import anatqc
import logging
import argparse as ap
import anatqc.cli as cli

logger = logging.getLogger(__name__)

def main():
    parser = ap.ArgumentParser()
    parser.add_argument('-v', '--verbose', action='store_true')
    subparsers = parser.add_subparsers(help='sub-command help')
    # get mode
    parser_get = subparsers.add_parser('get', help='get -h')
    parser_get.add_argument('--label', required=True,
        help='XNAT MR Session name')
    parser_get.add_argument('--project',
        help='XNAT Project name')
    parser_get.add_argument('--bids-dir', required=True,
        help='Output BIDS directory')
    parser_get.add_argument('--xnat-alias',
        help='YAXIL authentication alias')
    parser_get.add_argument('--xnat-host',
        help='XNAT host')
    parser_get.add_argument('--xnat-user',
        help='XNAT username')
    parser_get.add_argument('--xnat-pass',
        help='XNAT password')
    parser_get.set_defaults(func=cli.get.do)
    # process mode
    parser_process = subparsers.add_parser('process', help='process -h')
    parser_process.add_argument('--partition', default='default',
        help='Job scheduler partition')
    parser_process.add_argument('--scheduler', default=None,
        help='Choose a specific job scheduler')
    parser_process.add_argument('--rate-limit', type=int, default=None, 
        help='Rate limit the number of tasks executed in parallel (1=serial)')
    parser_process.add_argument('--sub', required=True,
        help='BIDS subject')
    parser_process.add_argument('--ses',
        help='BIDS session')
    parser_process.add_argument('--mod', default='T1w',
        help='BIDS modality')
    parser_process.add_argument('--run', default='1',
        help='BIDS run')
    parser_process.add_argument('--bids-dir', required=True,
        help='BIDS root directory')
    parser_process.add_argument('--dry-run', action='store_true',
        help='Do not actually execute any jobs')
    parser_process.add_argument('--sub-tasks', nargs='+', default=['morph', 'mriqc', 'vnav'],
        help='Run only certain sub tasks')
    parser_process.add_argument('--fs-license',
        help='Base64 encoded FreeSurfer license file')
    parser_process.add_argument('--xnat-alias',
        help='YAXIL authentication alias')
    parser_process.add_argument('--xnat-host',
        help='XNAT host')
    parser_process.add_argument('--xnat-user',
        help='XNAT username')
    parser_process.add_argument('--xnat-pass',
        help='XNAT password')
    parser_process.add_argument('--xnat-upload', action='store_true',
        help='Create and upload XNAT XAR')
    parser_process.add_argument('--keep-xar', action='store_true',
        help='Do not delete XAR file')
    parser_process.set_defaults(func=cli.process.do)
    # tandem (run get and process)
    parser_tandem = subparsers.add_parser('tandem', help='tandem -h')
    parser_tandem.add_argument('--label', required=True,
        help='XNAT MR Session name')
    parser_tandem.add_argument('--project',
        help='XNAT Project name')
    parser_tandem.add_argument('--bids-dir', required=True,
        help='Output BIDS directory')
    parser_tandem.add_argument('--run', default='1',
        help='BIDS run')
    parser_tandem.add_argument('--partition', default='default',
        help='Job scheduler partition')
    parser_tandem.add_argument('--scheduler', default=None,
        help='Choose a specific job scheduler')
    parser_tandem.add_argument('--rate-limit', type=int, default=None, 
        help='Rate limit the number of tasks executed in parallel (1=serial)')
    parser_tandem.add_argument('--dry-run', action='store_true',
        help='Do not actually execute any jobs')
    parser_tandem.add_argument('--sub-tasks', nargs='+', default=['morph', 'mriqc', 'vnav'],
        help='Run only certain sub tasks')
    parser_tandem.add_argument('--fs-license',
        help='Base64 encoded FreeSurfer license')
    parser_tandem.add_argument('--mock-fs', action='store_true',
        help='Extract mocked FreeSurfer data for testing')
    parser_tandem.add_argument('--xnat-alias',
        help='YAXIL authentication alias')
    parser_tandem.add_argument('--xnat-host',
        help='XNAT host')
    parser_tandem.add_argument('--xnat-user',
        help='XNAT username')
    parser_tandem.add_argument('--xnat-pass',
        help='XNAT password')
    parser_tandem.add_argument('--artifacts-dir', default='/artifacts',
        help='Location for generated assessors and resources')
    parser_tandem.set_defaults(func=cli.tandem.do)
    args = parser.parse_args()

    configure_logging(args.verbose)
    logger.info('Welcome to AnatQC version %s', anatqc.version())

    # fire parser_*.set_defaults(func=<function>)
    args.func(args)

def configure_logging(verbose):
    level = logging.INFO
    if verbose:
        level = logging.DEBUG
    logging.basicConfig(
        level=level,
        format='%(asctime)s.%(msecs)03d %(levelname)s %(module)s - %(funcName)s: %(message)s',
        datefmt='%Y-%m-%d %H:%M:%S'
    )

if __name__ == '__main__':
    main()

