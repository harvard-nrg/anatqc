# Anatomical Quality Control

1. [Summary](#summary)
2. [Installation](#installation)
3. [Requirements](#requirements)
4. [Get task](#get-task)
5. [Process task](#process-task)
6. [Container](#container)
   1. [Building](#building)
   2. [Running](#running)

## Summary
The anatomical quality control pipeline is broken up into two tasks. The 
[`get`](#get)
task will download your scan data from XNAT into a BIDS compatible directory. 
The 
[`process`](#process)
task will process data from a BIDS compatible directory through FreeSurfer, 
vNAV, and MRIQC.

## Installation
> For a containerized version of AnatQC, you may wish to skip to [the container section](#container).

Just use `pip`

```bash
pip install anatqc
```

## Requirements
The AnatQC pipeline has the following requirements that are not installed through 
`pip`

* [`dcm2niix`](https://github.com/rordenlab/dcm2niix)
* [`FreeSurfer`](https://surfer.nmr.mgh.harvard.edu/)
* [`MRIQC`](https://mriqc.readthedocs.io/en/stable/)

## Get mode
To download your data from XNAT directly into a BIDS directory structure, you 
must add special notes to your scans within XNAT. vNAV scan notes should contain 
`MOVE_001`, `MOVE_002`, ..., `MOVE_N`. Anatomical scans should contain 
`ANAT_001`, `ANAT_002`, ..., `ANAT_N`. Once these notes are in place you 
can execute

```bash
anatQC.py get --xnat {{ xnat }} --label {{ session }} --project {{ project }} --bids-dir {{ bids directory }}
```

## Process mode
To process your data, note that you must refer to your data using the BIDS naming convention

```bash
anatQC.py process --sub {{ subject }} --ses {{ session }} --bids-dir {{ bids input }}
```

## Singularity
To build an AnatQC Singularity image, take the `Singularity` definition file 
from this repository and run

```bash
singularity build anatqc.sif Singularity
```

> Take note that both FreeSurfer and FSL are installed from archives uploaded to Dropbox.

### running
To invoke the AnatQC `get` task

```bash
singularity run --app anatqc anatqc.sif get --xnat {{ xnat }} --label {{ label }} --project {{ project }} --bids-dir {{ bids directory }}
```

To invoke the AnatQC `process` task

```bash
singularity run --bind {{ license.txt }}:/sw/apps/freesurfer/license.txt --app anatqc anatqc.sif process --sub {{ sub }} --ses {{ ses }} --bids-dir {{ bids directory }} --rate-limit 1 --submit"
```

Note that you must `--bind` your local FreeSurfer license file into the container at runtime.

