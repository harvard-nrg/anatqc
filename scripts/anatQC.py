#!/usr/bin/env python

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
    parser_get.add_argument('--alias', default='cbscentral')
    parser_get.add_argument('--label')
    parser_get.add_argument('--project')
    parser_get.add_argument('--bids-dir')
    parser_get.set_defaults(func=cli.get.do)
    # process mode
    parser_process = subparsers.add_parser('process', help='process -h')
    parser_process.add_argument('--partition', default='default')
    parser_process.add_argument('--scheduler', default=None)
    parser_process.add_argument('--rate-limit', type=int, default=None, 
        help='Impose a rate limit on the number of tasks executed in parallel')
    parser_process.add_argument('--sub')
    parser_process.add_argument('--ses')
    parser_process.add_argument('--mod', default='T1w')
    parser_process.add_argument('--run', default='1')
    parser_process.add_argument('--bids-dir', required=True)
    parser_process.add_argument('--save-xar', default='xnat.zip')
    parser_process.add_argument('--config')
    parser_process.add_argument('--submit', action='store_true')
    parser_process.add_argument('--sub-tasks', nargs='+', default=['morph', 'mriqc', 'vnav'])
    parser_process.set_defaults(func=cli.process.do)
    args = parser.parse_args()

    configure_logging(args.verbose)

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

