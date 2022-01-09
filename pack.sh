#!/bin/bash

# P A R A M S

dbtag=$1
shift
if [ -z "${dbtag}" ]; then
  dbtag=31
fi
dbdir=$1
shift
if [ -z "${dbdir}" ]; then
  dbdir=sql31
fi

# S O U R C E S

source define_colors.sh

# M A I N

echo -e "${C}packing ${Y}${dbtag}${Z}"
echo "ant pack with dbtag=${dbtag}"
ant -f make-dist-sql.xml -Ddbdir=${dbdir} -Ddbtag=${dbtag}
