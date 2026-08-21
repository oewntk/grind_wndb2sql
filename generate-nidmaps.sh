#!/bin/bash

#
# Copyright (c) 2021-2024. Bernard Bou.
#

set -e

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

jar=wndb2sql-3.0.1-SNAPSHOT-uber.jar
if [ ! -e "${jar}" ]; then
  if [ ! -e "target/${jar}" ]; then
    echo "Non existing uber jar" >&2
    exit 1
    fi
  ln -s "target/${jar}"
  fi
if [ ! -e "${jar}" ]; then
  echo "Non existing uber jar" >&2
  exit 2
  fi
java -ea -cp "${jar}" org.oewntk.grind.wndb2sql.Mapper "${indir}" "${indir2}" "${outdir}"
