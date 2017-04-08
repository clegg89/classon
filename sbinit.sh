#!/bin/bash
# Make sure sandbox and environment are setup

git submodule update --init --recursive

if [ -e ./repo-deps/openembedded-core/bitbake ]; then
  echo "Bitbake symlink OK"
else
  echo "Adding bitbake symlink"
  ln -s ../bitbake repo-deps/openembedded-core/bitbake
fi

