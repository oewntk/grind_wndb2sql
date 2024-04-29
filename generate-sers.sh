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
outdir=$3
if [ -z "${outdir}" ]; then
  outdir=sers31
fi

jar=target/wndb2sql-1.0.5-uber.jar
java -ea -cp "${jar}" org.oewntk.grind.wndb2sql.Serializer "${indir}" "${indir2}" "${outdir}"
