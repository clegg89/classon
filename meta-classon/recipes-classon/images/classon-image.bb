require recipes-graphics/images/core-image-x11.bb

SUMMARY = "A console-only image that fully supports the target device \
hardware."

# customize IMAGE_FEATURES as follows  
IMAGE_FEATURES += "debug-tweaks ssh-server-openssh"  

# packagegroup-core-tools-profile will build and install tracing and profiling tools to the target image.  
# packagegroup-core-buildessential will build and install autotools, gcc, etc. to the target image.  
# kernel-modules for install of the kernel modules.  
# kernel-devsrc for building out of tree modules.  
# IMAGE_ROOTFS_EXTRA_SPACE_append for adding extra space to the target rootfs image.  
   
IMAGE_INSTALL += "\
	classon-rootfs\
	i2c-tools \
	v4l-utils \
	iperf3 \
	python-core \
	python-subprocess \
	opencv \
	opencv-samples \
     	kernel-modules \  
     	${CORE_IMAGE_EXTRA_INSTALL} \  
	packagegroup-core-boot ${ROOTFS_PKGMANAGE_BOOTSTRAP} udev-extraconf \
	packagegroup-core-ssh-openssh \
	nano \
	gstreamer1.0 gstreamer1.0-plugins-imx-meta \
	gstreamer1.0-plugins-base-meta gstreamer1.0-plugins-good-meta \
	gstreamer1.0-plugins-bad-meta gstreamer1.0-plugins-good \
	gstreamer1.0-plugins-bad gstreamer1.0-plugins-ugly \
	gstreamer1.0-libav gstreamer1.0-plugins-base-playback \
	gstreamer1.0-meta-base \
	gstreamer1.0-meta-video \
	gstreamer1.0-meta-audio \
	gstreamer1.0-meta-debug \
	gstreamer1.0-plugins-imx gstreamer1.0-plugins-ugly-meta \
	pulseaudio pulseaudio-server \
	alsa-utils alsa-utils-speakertest \
	gst-fsl-plugin gst-ffmpeg\
	gstreamer1.0-plugins-good-multifile-dev \
	"
##removed packages
#                        python-gst
#                        rsync

COMMERCIAL_AUDIO_PLUGINS ?= " \
	gst-plugins-ugly-mad \
	gst-plugins-ugly-mpegaudioparse \
	gst-fsl-plugin \
	"

COMMERCIAL_VIDEO_PLUGINS ?= " \
	gst-plugins-ugly-mpeg2dec \
	gst-plugins-ugly-mpegstream \
	gst-plugins-bad-mpegvideoparse \
	"

CORE_IMAGE_EXTRA_INSTALL += " \
	alsa-utils \
	gst-ffmpeg \
	gst-plugins-base-videotestsrc \
	gst-plugins-bad-fbdevsink \
	gst-plugins-good-isomp4 \
	"
inherit core-image  
  
# Add extra space to the rootfs image  
IMAGE_ROOTFS_EXTRA_SPACE_append += "+ 1048576"  

LICENSE = "MIT"
