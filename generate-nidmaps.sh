#!/bin/bash

#
# Copyright (c) 2021-2024. Bernard Bou.
#

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
  outdir=nidmaps31
fi

jar=target/wndb2sql-2.2.0-uber.jar
java -ea -cp "${jar}" org.oewntk.grind.wndb2sql.Mapper "${indir}" "${indir2}" "${outdir}"
