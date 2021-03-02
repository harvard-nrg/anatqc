import os
import re
import sys
import json

class BIDS(object):
    def __init__(self, base, sub, ses=None):
        self._base = base
        self._sub = sub
        self._ses = ses

    @staticmethod
    def basename(sub, mod, ses=None, acq=None, ce=None, rec=None, run=None, defacemask=False):
        # add sub (required)
        b = 'sub-' + sub.replace('sub-', '')
        if ses:
            b += '_ses-' + ses.replace('ses-', '')
        if acq:
            b += '_acq-' + acq.replace('acq-', '') 
        if ce:
            b += '_ce-' + ce.replace('ce-', '')
        if rec:
            b += '_rec-' + rec.replace('rec-', '')
        if run:
            b += '_run-' + str(run).replace('run-', '')
        if defacemask:
            b += '_mod-' + mod.replace('mod-', '')
            b += '_defacemask'
        else:
            b += '_' + mod.replace('mod-', '')
        return b
    
    @staticmethod
    def sidecar_for_image(image):
        base = re.sub('\..*$', '', image)
        return base + '.json'

    def derivatives_dir(self, name):
        parts = [
            self._sub
        ]
        if self._ses:
            parts.append(self._ses)
        return os.path.join(
            self._base,
            'derivatives',
            name,
            *parts
        )

    def raw_anat(self, mod, sourcedata=False, **kwargs):
        parts = [
            self._sub
        ]
        if self._ses:
            parts.append(self._ses)
        if sourcedata:
            dirname = os.path.join(self._base, 'sourcedata', *parts, 'anat')
        else:
            dirname = os.path.join(self._base, *parts, 'anat')
        acq = kwargs.get('acq', None)
        ce = kwargs.get('ce', None)
        rec = kwargs.get('rec', None)
        run = kwargs.get('run', None)
        brainmask = kwargs.get('brainmask', None)
        if acq:
            parts.append('acq-' + acq)
        if ce:
            parts.append('ce-' + ce)
        if rec:
            parts.append('rec-' + rec)
        if run:
            parts.append('run-' + str(run))
        if brainmask:
            parts.append('mod-' + mod + '_brainmask')
        else:
            parts.append(mod)
        basename = '_'.join(parts)
        return dirname, basename

    @staticmethod
    def parse(filename):
        result = {
            'filename': filename
        }
        # get extension
        match = re.match('^.*(.dicom|.json|.nii|.nii.gz)$', filename)
        result['ext'] = match.group(1) if match else None
        # get sub component
        match = re.match('^sub-([^\W_]+).*\.(dicom|json|nii|nii.gz)$', filename)
        result['sub'] = match.group(1) if match else None
        # get ses component
        match = re.match('.*_ses-([^\W_]+).*\.(dicom|json|nii|nii.gz)$', filename)
        result['ses'] = match.group(1) if match else None
        # get acq component
        match = re.match('.*_acq-([^\W_]+).*\.(dicom|json|nii|nii.gz)$', filename)
        result['acq'] = match.group(1) if match else None
        # get run component
        match = re.match('.*_run-(\d+).*\.(dicom|json|nii|nii.gz)$', filename)
        result['run'] = match.group(1) if match else None    
        # get rec component
        match = re.match('.*_rec-(\d+).*\.(dicom|json|nii|nii.gz)$', filename)
        result['rec'] = match.group(1) if match else None
        # get ce component
        match = re.match('.*_ce-(\d+).*\.(dicom|json|nii|nii.gz)$', filename)
        result['ce'] = match.group(1) if match else None
        # get defacemask component
        match = re.match('.*(_defacemask)\.(dicom|json|nii|nii.gz)$', filename)
        result['defacemask'] = True if match else None
        # get modality component
        if result['defacemask']:
            match = re.match('.*_mod-([^\W_]+)_defacemask\.(dicom|json|nii|nii.gz)$', filename)
            result['mod'] = match.group(1) if match else None
        else:
            match = re.match('.*_([^\W_]+)\.(dicom|json|nii|nii.gz)$', filename)
            result['mod'] = match.group(1) if match else None
        return result

