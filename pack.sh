#!/bin/bash

#
# Copyright (c) 2024. Bernard Bou.
#

set -e

# P A R A M S

dbtag=$1
[ "$#" -eq 0 ] || shift
if [ -z "${dbname}" ]; then
  dbname=wn
fi
dbtag=$1
[ "$#" -eq 0 ] || shift
if [ -z "${dbtag}" ]; then
  dbtag=31
fi
dbversion=$1
[ "$#" -eq 0 ] || shift
if [ -z "${dbversion}" ]; then
  dbversion=1
fi
dbdir=$1
[ "$#" -eq 0 ] || shift
if [ -z "${dbdir}" ]; then
  dbdir=sql31
fi

# C O L O R S

export R='\u001b[31m'
export G='\u001b[32m'
export B='\u001b[34m'
export Y='\u001b[33m'
export M='\u001b[35m'
export C='\u001b[36m'
export Z='\u001b[0m'

# M A I N

echo -e "${C}packing ${Y}${dbtag}${Z}"
echo "ant pack with dbtag=${dbtag}"
ant -f make-dist-sql.xml -Ddbdir=${dbdir} -Ddbname=${dbname} -Ddbtag=${dbtag} -Dversion="${dbversion}"
