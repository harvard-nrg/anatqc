# Anatomical Quality Control (beta)
AnatQC is an automated quality control pipeline for T1-weighted (with or without vNav) MRI 
scans. AnatQC is built on top of these excellent packages: [`dcm2niix`](https://github.com/rordenlab/dcm2niix), 
[`FreeSurfer`](https://surfer.nmr.mgh.harvard.edu/), [`vNav`](https://github.com/mharms/parse_vNav_Motion), 
and [`MRIQC`](https://mriqc.readthedocs.io/en/stable/).

1. [Summary](#summary)
2. [Installation](#installation)
3. [Get command](#get-command)
4. [Process command](#process-command)
5. [Container](#container)
   1. [Download it](#download-it)
   2. [Run it](#run-it)
   3. [Build it (optional)](#build-it-optional)
   4. [Develop it (optional)](#develop-it-optional)

## Summary
AnatQC is  broken up into two commands:

* The [`get command`](#get-command) will help you download your scan data from [XNAT](https://www.xnat.org/) into a 
  [BIDS](https://bids.neuroimaging.io/) directory.
* The [`process command`](#process-command) will send your data (from [BIDS](https://bids.neuroimaging.io/)) through AnatQC.

## Installation
Please visit the [container](#container) section, which is by far the simplest way to install 
and use AnatQC.

## Get command
For help downloading your data from [XNAT](https://www.xnat.org/) directly into 
[BIDS](https://bids.neuroimaging.io/), you need to add special notes to your scans 
within [XNAT](https://www.xnat.org/). Your anatomical `T1w` scan note field(s)
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

## Process command
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
To download, build, and run the AnatQC as a container, you need to install 
[Singularity](https://sylabs.io/singularity/) (the Community Edition will do).

### download it
You can download the AnatQC container directly from
[Singularity Hub](https://singularity-hub.org/collections/5018)
with the following command

```bash
singularity pull --name anatqc.sif shub://harvard-nrg/anatqc
```

### run it
To invoke the AnatQC [`get command`](#get-command) within the container

```bash
singularity run --app anatqc anatqc.sif get --alias {{ xnat }} --label {{ label }} --project {{ project }} --bids-dir {{ bids directory }}
```

To invoke the AnatQC [`process command`](#process-command) within the container

```bash
singularity run --bind {{ license.txt }}:/sw/apps/freesurfer/license.txt --app anatqc anatqc.sif process --sub {{ sub }} --ses {{ ses }} --bids-dir {{ bids directory }} --rate-limit 1 --submit
```

> Note that the additional placeholder `{{ license.txt }}` must be replaced with
> the path to a valid FreeSurfer license.

### build it (optional)
If you want to build the container by hand, take the
[Singularity definition file](https://github.com/harvard-nrg/anatqc/blob/main/Singularity) 
from this repository and build it

```bash
singularity build anatqc.sif <definition file>
```

> Note: FreeSurfer and FSL will be pulled from unofficial archives on Dropbox.

### develop it (optional)
If you want to help develop AnatQC

```bash
git clone https://github.com/harvard-nrg/anatqc
cd anatqc
singularity shell --bind {{ license.txt }}:/sw/apps/freesurfer/license.txt --app anatqc anatqc.sif
Singularity> pipenv install
[...]
Installing dependencies from Pipfile.lock (cdc170)...
  🐍   ▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉ 37/37 — 00:00:49
```

> Note that the additional placeholder `{{ license.txt }}` must be replaced with
> the path to a valid FreeSurfer license.

Now you can launch a `pipenv shell` and invoke `anatQC.py` by hand

```bash
Singularity> pipenv shell
(anatqc) anatQC.py --help
usage: anatQC.py [-h] [-v] {get,process} ...
[...]
```

From this point, you can start tinkering around with AnatQC source code. If you 
need to modify any installed dependencies (e.g., `morphometry`, `vnav`) those 
should be installed under `.venv/lib/python3.6/site-packages` and/or `.venv/bin`.
Bon appétit!
