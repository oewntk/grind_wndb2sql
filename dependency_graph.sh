#!/bin/bash

#
# Copyright (c) 2024. Bernard Bou.
#

set -e

graph=grind-wndb2sql
todir=images/

mvn dependency:tree \
-DoutputType=dot \
-DoutputFile=${todir}${graph}.dot

dot -Tpng -o "${todir}${graph}.png" "${todir}${graph}.dot"
