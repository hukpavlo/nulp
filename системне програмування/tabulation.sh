#!/bin/bash

float_eval() {
  echo $(echo "scale=2; $1" | bc -l | sed -r 's/^(-?)\./\10./')
}

float_cond() {
  echo $(echo "$1" | bc) != 0
}

while getopts "a:b:c:d:s:" parameter; do
  case $parameter in
  a) xMin=${OPTARG} ;;
  b) xMax=${OPTARG} ;;
  c) yMin=${OPTARG} ;;
  d) yMax=${OPTARG} ;;
  s) step=${OPTARG} ;;
  esac
done

x=$xMin

until [ $(float_cond "$x > $xMax") ]; do
  y=$yMin

  until [ $(float_cond "$y > $yMax") ]; do
    echo x=$x y=$y z = $(float_eval "$x * $x + $y * $y")
    y=$(float_eval "$y + 0.1")
  done

  x=$(float_eval "$x + 0.1")
done
