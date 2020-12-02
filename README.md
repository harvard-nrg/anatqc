# Anatomical Quality Control (beta)
AnatQC is an automated quality control pipeline for T1-weighted (with or without vNav) MRI 
scans. AnatQC is built on top of these excellent packages: [`dcm2niix`](https://github.com/rordenlab/dcm2niix), 
[`FreeSurfer`](https://surfer.nmr.mgh.harvard.edu/), [`vNav`](https://github.com/mharms/parse_vNav_Motion), 
and [`MRIQC`](https://mriqc.readthedocs.io/en/stable/).

1. [Summary](#summary)
2. [Installation](#installation)
3. [Get task](#get-mode)
4. [Process task](#process-mode)
5. [Container](#container)
   1. [Build it](#build-it)
   2. [Run it](#run-it)

## Summary
AnatQC is  broken up into two tasks:

* The [`get`](#get-mode) task will help you download your scan data from [XNAT](https://www.xnat.org/) into a 
  [BIDS](https://bids.neuroimaging.io/) directory.
* The [`process`](#process-mode) task will process your data (from [BIDS](https://bids.neuroimaging.io/)) through AnatQC.

## Installation
Please visit the [container](#container) section, which is by far the simplest way to install 
and use AnatQC.

## Get mode
For help downloading your data from [XNAT](https://www.xnat.org/) directly into 
[BIDS](https://bids.neuroimaging.io/), you need to add special notes to your scans 
within [XNAT](https://www.xnat.org/). Your anatomical (`T1w`) scan note fields
should contain `ANAT_001`, `ANAT_002`, ..., `ANAT_N` and the corresponding vNavs 
(if there are any) should contain `MOVE_001`, `MOVE_002`, ..., `MOVE_N`. 

Once these notes are set, you can run the `get` command

```bash
anatQC.py get --alias {{ xnat }} --label {{ session }} --project {{ project }} --bids-dir {{ bids directory }}
```

| placeholder            | description                | required |
|------------------------|--------------------------------------------------------------------------------------------------------|----------|
| `{{ xnat }}`           | XNAT alias from your [YAXIL authentication file](https://yaxil.readthedocs.io/en/latest/xnat_auth.html) |  yes     |
| `{{ session }}`        | XNAT MR Session label      |  yes     |
| `{{ project }}`        | XNAT Project               |  no      |
| `{{ bids directory }}` | Destination BIDS directory |  no      |

## Process mode
To process your data, you must refer to your data using the [BIDS](https://bids.neuroimaging.io/) naming convention

```bash
anatQC.py process --sub {{ subject }} --ses {{ session }} --bids-dir {{ bids directory }}
```

| placeholder             | description    | required |
|-------------------------|----------------|----------|
| `{{ sub }}`             | BIDS `sub-*`   |  yes     |
| `{{ session }}`         | BIDS `ses-*`   |  yes     |
| `{{ bids directory }}`  | BIDS directory |  yes     |

## Container
To build (and in many cases run) AnatQC as a container, you need to install 
[Singularity](https://sylabs.io/singularity/).

### build it
Take the
[`Singularity`](https://github.com/harvard-nrg/anatqc/blob/main/Singularity) 
definition file from this repository and `build` it

```bash
singularity build anatqc.sif Singularity
```

> Note: FreeSurfer and FSL will be pulled from unofficial archives on Dropbox.

### run it
To invoke the AnatQC [`get`](#get-mode) task

```bash
singularity run --app anatqc anatqc.sif get --alias {{ xnat }} --label {{ label }} --project {{ project }} --bids-dir {{ bids directory }}
```

To invoke the AnatQC [`process`](#process-mode) task

```bash
singularity run --bind {{ license.txt }}:/sw/apps/freesurfer/license.txt --app anatqc anatqc.sif process --sub {{ sub }} --ses {{ ses }} --bids-dir {{ bids directory }} --rate-limit 1 --submit"
```

Note that the additional placeholder `{{ license.txt }}` must be replaced with 
the path to a valid FreeSurfer license.

