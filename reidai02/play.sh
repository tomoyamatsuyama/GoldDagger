#!/bin/sh

javac Solver.java

for i in `seq 1 10`; do 
  java Gold | head -n 1 | awk '{print $1}'
done | awk '{print $1; a += $1 } END {print a / 10}'

