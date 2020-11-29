#!/bin/bash

float_eval() {
  echo $(echo "scale=2; $1" | bc -l | sed -r 's/^(-?)\./\10./')
}

float_cond() {
  echo $(echo "$1" | bc) != 0
}

while getopts "a:b:c:" parameter; do
  case $parameter in
  a) a=${OPTARG} ;;
  b) b=${OPTARG} ;;
  c) c=${OPTARG} ;;
  esac
done

discriminant=$(float_eval "$b * $b - 4 * $a * $c")

if [ $(float_cond "$discriminant == 0") ]; then
  echo x = $(float_eval "$b * -1 / (2 * $a)")
  exit 0
fi

if [ $(float_cond "$discriminant > 0") ]; then
  echo x1 = $(float_eval "(-1 * $b + sqrt($discriminant)) / (2 * $a)")
  echo x2 = $(float_eval "(-1 * $b - sqrt($discriminant)) / (2 * $a)")
else
  echo "discriminant is less than 0"
fi
