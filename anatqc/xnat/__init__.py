import re
import os
import io
import sys
import glob
import yaml
import json
import lxml
import zipfile
import logging
from lxml import etree
from anatqc.bids import BIDS

logger = logging.getLogger(__name__)

MRIQC_METRICS = [
    'cjv', 'cnr', 'efc', 'fber', 
    'fwhm_avg', 'fwhm_x', 'fwhm_y', 'fwhm_z',
    'icvs_csf', 'icvs_gm', 'icvs_wm',
    'inu_med', 'inu_range', 
    'qi_1', 'qi_2',
    'rpve_csf', 'rpve_gm', 'rpve_wm',
    'size_x', 'size_y', 'size_z',
    'snr_csf', 'snr_gm', 'snr_total', 'snr_wm',
    'snrd_csf', 'snrd_gm', 'snrd_total', 'snrd_wm', 
    'spacing_x', 'spacing_y', 'spacing_z',
    'summary_bg_k', 'summary_bg_mad', 'summary_bg_mean', 'summary_bg_median', 
    'summary_bg_n', 'summary_bg_p05', 'summary_bg_p95', 'summary_bg_stdv',
    'summary_csf_k', 'summary_csf_mad', 'summary_csf_mean', 'summary_csf_median',
    'summary_csf_n', 'summary_csf_p05', 'summary_csf_p95', 'summary_csf_stdv',
    'summary_gm_k', 'summary_gm_mad', 'summary_gm_mean', 'summary_gm_median',
    'summary_gm_n', 'summary_gm_p05', 'summary_gm_p95', 'summary_gm_stdv',
    'summary_wm_k', 'summary_wm_mad', 'summary_wm_mean', 'summary_wm_median',
    'summary_wm_n', 'summary_wm_p05', 'summary_wm_p95', 'summary_wm_stdv',
    'tpm_overlap_csf', 'tpm_overlap_gm', 'tpm_overlap_wm',
    'wm2max'
]

PROTOCOL_SETTINGS = {
    'ABCD_T1w_MPR_vNav': {
        'min': 144,
        'max': 168
    }
}

class Report:
    def __init__(self, bids, sub, ses, run):
        self.module = os.path.dirname(__file__)
        self.bids = bids
        self.sub = sub
        self.run = run
        self.ses = ses if ses else ''
 
    def getdirs(self):
        self.dirs = {
            'morph': None,
            'mriqc': None,
            'vnav': None
        }
        for task in self.dirs.keys():
            d = os.path.join(
                self.bids,
                'derivatives',
                'anatqc-' + task,
                'sub-' + self.sub.replace('sub-', ''),
                'ses-' + self.ses.replace('ses-', ''),
                'anat'
            )
            mod = 'T1w'
            if task == 'vnav':
                mod = 'T1vnav'
            basename = BIDS.basename(**{
                'sub': self.sub,
                'ses': self.ses,
                'run': self.run,
                'mod': mod
            })
            dirname = os.path.join(d, basename)
            if os.path.exists(dirname):
                self.dirs[task] = dirname
        logger.debug('morph dir: %s', self.dirs['morph'])
        logger.debug('mriqc dir: %s', self.dirs['mriqc'])
        logger.debug('vnav dir: %s', self.dirs['vnav'])

    def build_assessment(self, output):
        '''
        Build XNAT assessment

        :param output: A path to a file (string) or file-like object
        '''
        basename = BIDS.basename(**{
                'sub': self.sub,
                'ses': self.ses,
                'run': self.run,
                'mod': 'T1w'
        })
        self.getdirs()
        # initialize namespaces
        ns = {
            None: 'http://www.neuroinfo.org/neuroinfo',
            'xs': 'http://www.w3.org/2001/XMLSchema',
            'xsi': 'http://www.w3.org/2001/XMLSchema-instance',
            'xnat': 'http://nrg.wustl.edu/xnat',
            'neuroinfo': 'http://www.neuroinfo.org/neuroinfo'
        }
        # read moph and vnav json sidecar for scan number
        T1w_ds = self.datasource('morph')
        vNav_ds = self.datasource('vnav') if self.dirs['vnav'] else None
        logger.info('T1w info %s', '|'.join(T1w_ds))
        if vNav_ds:
            logger.info('T1vnav info %s', '|'.join(vNav_ds))        
        # assessment id
        aid = '{0}_ANAT_{1}_AQC'.format(T1w_ds['experiment'], T1w_ds['scan'])
        logger.info('Assessor ID %s', aid)
        # root element
        xnatns = '{%s}' % ns['xnat']
        root = etree.Element('AnatQC', nsmap=ns)
        root.attrib['project'] = T1w_ds['project']
        root.attrib['ID'] = aid
        root.attrib['label'] = aid
        # get start date and time from morph provenance
        fname = os.path.join(self.dirs['morph'], 'logs', 'provenance.json')
        with open(fname) as fo:
            prov = json.load(fo)
        # add date and time
        etree.SubElement(root, xnatns + 'date').text = prov['start_date']
        etree.SubElement(root, xnatns + 'time').text = prov['start_time']
        # compile a list of files to be added to xnat:out section
        files = [
            {
                'filename': os.path.join(self.dirs['morph'], 'morphometrics', 'snapshots', 'img-T1w_axis-axial_mosaic.png'),
                'URI': '{0}_T1w_axial.png'.format(aid),
                'format': 'image/png',
                'label': 'T1w axial',
                'file_list': True
            },
            {
                'filename': os.path.join(self.dirs['morph'], 'morphometrics', 'snapshots', 'img-aseg_axis-axial_mosaic.png'),
                'URI': '{0}_aseg_axial.png'.format(aid),
                'format': 'image/png',
                'label': 'Segmentation axial',
                'file_list': True
            },
            {
                'filename': os.path.join(self.dirs['morph'], 'morphometrics', 'snapshots', 'img-brainmask_axis-axial_mosaic.png'),
                'URI': '{0}_brainmask_axial.png'.format(aid),
                'format': 'image/png',
                'label': 'Brainmask axial',
                'file_list': True
            },
            {
                'filename': os.path.join(self.dirs['morph'], 'morphometrics', 'snapshots', 'img-surf_axis-axial_mosaic.png'),
                'URI': '{0}_surface_axial.png'.format(aid),
                'format': 'image/png',
                'label': 'Surfaces axial',
                'file_list': True
            },
            {
                'filename': os.path.join(self.dirs['morph'], 'morphometrics', 'plots', 'aparc-laterality.png'),
                'URI': '{0}_aparc_laterality.png'.format(aid),
                'format': 'image/png',
                'label': 'Cortical Laterality',
                'file_list': True
            },
            {
                'filename': os.path.join(self.dirs['morph'], 'morphometrics', 'plots', 'aseg-laterality.png'),
                'URI': '{0}_aseg_laterality.png'.format(aid),
                'format': 'image/png',
                'label': 'Subcortical Laterality',
                'file_list': True
            },
            {
                'filename': os.path.join(self.dirs['mriqc'], basename + '.html'),
                'URI': '{0}_mriqc.html'.format(aid),
                'format': 'text/html',
                'label': 'MRIQC Report',
                'file_list': True

            },
            {
                'filename': os.path.join(self.dirs['vnav'], 'vNav_Motion.json'),
                'URI': '{0}_vNav_Motion.json'.format(aid),
                'format': 'text/html',
                'label': 'vNav Report',
                'file_list': True
            }
        ]
        # not all T1w scans have a vNav
        if self.dirs['vnav']:
            files.extend([
                {
                    'filename': os.path.join(self.dirs['vnav'], 'vNavMotionScoresMax.png'),
                    'URI': '{0}_vNavMotionScoresMax.png'.format(aid),
                    'format': 'image/png',
                    'label': 'vNav Motion Scores Max',
                    'file_list': True
                },
                {
                    'filename': os.path.join(self.dirs['vnav'], 'vNavMotionScoresRMS.png'),
                    'URI': '{0}_vNavMotionScoresRMS.png'.format(aid),
                    'format': 'image/png',
                    'label': 'vNav Motion Scores RMS',
                    'file_list': True
                }
            ])
        # add xnat:out
        xnat_out = etree.SubElement(root, xnatns + 'out')
        for f in files:
            e = etree.SubElement(xnat_out, xnatns + 'file')
            e.attrib['format'] = f['format']
            e.attrib['label'] = f['label']
            e.attrib['URI'] = f['URI']
            e.attrib['{http://www.w3.org/2001/XMLSchema-instance}type'] = 'xnat:resource'
            if f['file_list']:
                tags = etree.SubElement(e, xnatns + 'tags')
                etree.SubElement(tags, xnatns + 'tag').text = 'file_list'
        # start building XML
        xnatns = '{%s}' % ns['xnat']
        etree.SubElement(root, xnatns + 'imageSession_ID').text = T1w_ds['experiment_id']
        etree.SubElement(root, 't1w_scan_id').text = T1w_ds['scan']
        if self.dirs['vnav']:
            etree.SubElement(root, 'vnav_scan_id').text = vNav_ds['scan']
        else:
            etree.SubElement(root, 'vnav_scan_id').text = 'n/a'
        etree.SubElement(root, 'session_label').text = T1w_ds['experiment']
        # add freesurfer element
        morph_elm = etree.SubElement(root, 'morph')
        # add mri_cnr data
        fname = os.path.join(self.dirs['morph'], 'morphometrics', 'stats', 'mri_cnr.json')
        with open(fname) as fo:
            mri_cnr = json.load(fo)
        etree.SubElement(morph_elm, 'mri_cnr_tot').text = str(mri_cnr['tot_cnr'])
        # add wm_anat_snr data
        fname = os.path.join(self.dirs['morph'], 'morphometrics', 'stats', 'wm_anat_snr.json')
        with open(fname) as fo:
            wm_anat_snr = json.load(fo)
        etree.SubElement(morph_elm, 'wm_anat_snr').text = str(wm_anat_snr['snr'])
        # add lh euler holes, cnr, gray/white, gray/csf
        fname = os.path.join(self.dirs['morph'], 'morphometrics', 'stats', 'lh.mris_euler_number.json')
        with open(fname) as fo:
            lh_euler = json.load(fo)
        etree.SubElement(morph_elm, 'lh_euler_holes').text = str(lh_euler['holes'])
        etree.SubElement(morph_elm, 'lh_cnr').text = str(mri_cnr['lh_cnr'])
        etree.SubElement(morph_elm, 'lh_gm_wm_cnr').text = str(mri_cnr['lh_gm_wm_cnr'])
        etree.SubElement(morph_elm, 'lh_gm_csf_cnr').text = str(mri_cnr['lh_gm_csf_cnr'])
        # add rh euler holes, cnr, gray/white, gray/csf
        fname = os.path.join(self.dirs['morph'], 'morphometrics', 'stats', 'rh.mris_euler_number.json')
        with open(fname) as fo:
            rh_euler = json.load(fo)
        etree.SubElement(morph_elm, 'rh_euler_holes').text = str(rh_euler['holes'])
        etree.SubElement(morph_elm, 'rh_cnr').text = str(mri_cnr['rh_cnr'])
        etree.SubElement(morph_elm, 'rh_gm_wm_cnr').text = str(mri_cnr['rh_gm_wm_cnr'])
        etree.SubElement(morph_elm, 'rh_gm_csf_cnr').text = str(mri_cnr['rh_gm_csf_cnr'])
        # add mriqc element
        mriqc_elm = etree.SubElement(root, 'mriqc')
        fname = os.path.join(
            self.dirs['mriqc'],
            self.sub,
            self.ses,
            'anat',
            basename + '.json'
        )
        with open(fname) as fo:
            mriqc = json.load(fo)
        for metric in MRIQC_METRICS:
            etree.SubElement(mriqc_elm, metric).text = str(mriqc[metric])
        # add vnav element
        if self.dirs['vnav']:
            vnav_elm = etree.SubElement(root, 'vnav')
            # count the number of vNav transforms
            fname = os.path.join(self.dirs['vnav'], 'vNav_Motion.json')
            with open(fname) as fo:
                vnav = json.load(fo)
            n_vnav_acq = len(vnav['Transforms'])
            rms_per_min = vnav['MeanMotionScoreRMSPerMin']
            max_per_min = vnav['MeanMotionScoreMaxPerMin']
            moco_fail = '0'
            if vnav['Failed']:
                moco_fail = vnav['Failed']['Acquisition']
            T1w_protocol = self.protocol('morph')
            vnav_min = PROTOCOL_SETTINGS[T1w_protocol]['min']
            vnav_max = PROTOCOL_SETTINGS[T1w_protocol]['max']
            logger.info('vNav min=%s, max=%s (%s)', vnav_min, vnav_max, T1w_protocol)
            etree.SubElement(vnav_elm, 'vnav_min').text = str(vnav_min)
            etree.SubElement(vnav_elm, 'vnav_max').text = str(vnav_max)
            etree.SubElement(vnav_elm, 'vnav_acq_tot').text = str(n_vnav_acq)
            etree.SubElement(vnav_elm, 'vnav_reacq').text = str(n_vnav_acq - vnav_min)
            etree.SubElement(vnav_elm, 'mean_mot_rms_per_min').text = str(rms_per_min)
            etree.SubElement(vnav_elm, 'mean_mot_max_per_min').text = str(max_per_min)
            etree.SubElement(vnav_elm, 'vnav_failed').text = str(moco_fail)
        # build the archive
        if isinstance(output, str):
            output = open(output, 'w')
        with zipfile.ZipFile(output, 'w') as zf:
            for f in files:
                filename = f['filename']
                arcname = os.path.join('ASSESSMENT_FOLDER', f['URI'])
                logger.info('adding %s to %s', filename, arcname)
                zf.write(filename, arcname)
            zf.writestr('ASSESSMENT.XML', etree.tostring(root, pretty_print=True))

    def datasource(self, task):
        basename = os.path.basename(self.dirs[task])
        sidecar = os.path.join(self.dirs[task], 'logs', basename + '.json')
        if task == 'vnav':
            sidecar = sidecar.replace('_T1vnav.json', '_split-1_T1vnav.json')
        if not os.path.exists(sidecar):
            raise FileNotFoundError(sidecar)
        with open(sidecar) as fo:
            js = json.load(fo)
        return js['DataSource']['application/x-xnat']

    def protocol(self, task):
        basename = os.path.basename(self.dirs[task])
        sidecar = os.path.join(self.dirs[task], 'logs', basename + '.json')
        if not os.path.exists(sidecar):
            raise FileNotFoundError(sidecar)
        with open(sidecar) as fo:
            js = json.load(fo)
        return js['ProtocolName']
