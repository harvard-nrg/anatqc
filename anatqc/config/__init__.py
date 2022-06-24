import os
import yaml

__dir__ = os.path.dirname(__file__)

def default():
    conf = os.path.join(
        __dir__,
        'anatqc.yaml'
    )
    return conf
