#!/bin/bash

while getopts "p:" parameter; do
  case $parameter in
  p) folder_path=${OPTARG} ;;
  esac
done

if [ ! $folder_path ]; then
  folder_path=$PWD
fi

eval cd $folder_path

for x in *; do
  if [ ! -s $x ]; then
    rm $x
  fi
done
