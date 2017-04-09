#!/bin/bash
# Make sure sandbox and environment are setup

#git submodule update --init --recursive
git submodule update --recursive

if [ -e ./repo-deps/openembedded-core/bitbake ]; then
  echo "Bitbake symlink OK"
else
  echo "Adding bitbake symlink"
  ln -s ../bitbake repo-deps/openembedded-core/bitbake
fi

source repo-deps/openembedded-core/oe-init-build-env build
