# classon
Classon Helmet Firmware

1. Environment Setup:
----------------------
source sbinit.sh


2. Build Image
---------------
cd build
bitbake classon-image

	--> Images output to:  build/tmp/deploy/images/solidrun-imx6/

3. Write SD Card
-----------------
sudo dd if=/build/tmp/deploy/images/solidrun-imx6/classon-image-solidrun-imx6.sdcard of=/dev/sd[X] bs=4M conv=fsync

	--> sd[x] is SD card device on your computer; eg. /dev/sdb  BE CAREFUL!!
