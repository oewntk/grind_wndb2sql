#!/bin/bash

#
# Copyright (c) 2021. Bernard Bou.
#
# indir (wndb)
# indir2 (wndb2)
# outdir (nid.sers + model.ser)

indir=$1
if [ -z "${indir}" ]; then
  indir=wndb31
fi
indir2=$2
if [ -z "${indir2}" ]; then
  indir2=wndb2
fi
outdir=$1
if [ -z "${outdir}" ]; then
  outdir=sers31
fi

java -cp oewn-grind-wndb2sql.jar org.oewntk.grind.wndb2sql.Serializer "${indir}" "${indir2}" "${outdir}"
