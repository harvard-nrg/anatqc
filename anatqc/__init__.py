import os
import tarfile

def archive(indir, output):
    with tarfile.open(output, 'w:gz') as tar:
        tar.add(indir, os.path.basename(indir))

