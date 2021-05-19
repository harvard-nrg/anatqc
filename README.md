# Anatomical Quality Control (beta)
AnatQC is an automated quality control pipeline for T1-weighted (with or 
without volumetric navigators) MRI scans. AnatQC is built on top of the 
excellent [`dcm2niix`](https://github.com/rordenlab/dcm2niix), 
[`FreeSurfer`](https://surfer.nmr.mgh.harvard.edu/), 
[`vNav`](https://github.com/mharms/parse_vNav_Motion), 
and [`MRIQC`](https://mriqc.readthedocs.io/en/stable/).

1. [Documentation](#documentation)
2. [Summary](#summary)
3. [Get command](#get-command)
4. [Process command](#process-command)
5. [Tandem command](#tandem-command)

## Documentation
For the latest documentation please head over to [anatqc.readthedocs.io](https://anatqc.readthedocs.io).

## Summary
AnatQC is  broken up into two commands:

* The [`get command`](#get-command) will help you download your scan data from [XNAT](https://www.xnat.org/) into a 
  [BIDS](https://bids.neuroimaging.io/) directory.
* The [`process command`](#process-command) will send your data (from [BIDS](https://bids.neuroimaging.io/)) through AnatQC.
* The [`tandem command`](#tandem-command) which runs both the `get` and `process` commands.

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
anatQC.py get --alias {{ xnat }} --label {{ session }} --bids-dir {{ bids directory }}
```

| placeholder            | description                | required |
|------------------------|--------------------------------------------------------------------------------------------------------|----------|
| `{{ xnat }}`           | [YAXIL auth file alias](https://yaxil.readthedocs.io/en/latest/xnat_auth.html) |  yes     |
| `{{ session }}`        | XNAT MR Session label      |  yes     |
| `{{ bids directory }}` | Destination BIDS directory |  yes     |

Execute `anatQC.py get --help` for more options.

## Process command
To process your data, you must refer to your data using the [BIDS](https://bids.neuroimaging.io/) naming convention

```bash
anatQC.py process --sub {{ subject }} --ses {{ session }} --bids-dir {{ bids directory }}
```

| placeholder             | description    | required |
|-------------------------|----------------|----------|
| `{{ sub }}`             | BIDS `sub-*`   |  yes     |
| `{{ session }}`         | BIDS `ses-*`   |  no      |
| `{{ bids directory }}`  | BIDS directory |  yes     |

Execute `anatQC.py process --help` for more options.

## Tandem command
To be continued
