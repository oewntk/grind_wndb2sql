#!/bin/bash

#
# Copyright (c) 2021. Bernard Bou.
#
# indir (wndb)
# indir2 (wndb2)
# outdir (sql/data)

IN="$1"
if [ -z "$1" ]; then
	IN=wndb31
fi
echo "WNDB:  ${IN}" 1>&2;

IN2="$2"
if [ -z "$2" ]; then
	IN2=wndb2
fi
echo "WNDB2: ${IN2}" 1>&2;

OUTDIR="$3"
if [ -z "$3" ]; then
	OUTDIR=sql31/data
fi
mkdir -p "${OUTDIR}"
echo "DIR:   ${OUTDIR}" 1>&2;

java -ea -jar oewn-grind-wndb2sql.jar "${IN}" "${IN2}" "${OUTDIR}"
