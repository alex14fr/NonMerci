PLATFORMDIR = /opt/cmdline-tools/platforms/android-34
BUILDTOOLDIR = /opt/cmdline-tools/build-tools/34.0.0
D8 = $(BUILDTOOLDIR)/d8
AAPT = $(BUILDTOOLDIR)/aapt
APKSIGNER = $(BUILDTOOLDIR)/apksigner
KEYTOOL = keytool
JAVAC = javac
JAVACFLAGS = -g:none

CLASSES = Receiver.class MActivity.class

all: NonMerci.apk

store.jks:
	$(KEYTOOL) -genkeypair -keystore $@ -keyalg RSA -keysize 2048

%.class: %.java
	$(JAVAC) $(JAVACFLAGS) --source 8 --target 8 -cp $(PLATFORMDIR)/android.jar $<

classes.dex: $(CLASSES)
	$(D8) --no-desugaring --output . $(CLASSES)

NonMerci.apk: store.jks classes.dex AndroidManifest.xml
	test -d out || mkdir out
	ln -s ../classes.dex out/
	$(AAPT) p -f -M AndroidManifest.xml -F $@ -I $(PLATFORMDIR)/android.jar out
	$(APKSIGNER) sign --ks store.jks $@

clean:
	rm -fr *.class *.dex *.apk out/

