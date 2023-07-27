# Non merci !

_Non merci_ (French for "no, thanks") is a non-configurable, very minimalist call blocker for numbers starting with one of the prefixes designated by ARCEP (the French telecom regulator) for use by call spammers. 

If you are outside of France or need more features, you should probably checkout the excellent [NoPhoneSpam](https://gitlab.com/bitfireAT/NoPhoneSpam/). _Non merci_ is a stripped-down version of NoPhoneSpam.

The following hard-coded prefixes are blocked:

```
01 62
01 63
02 70
02 71
03 77
03 78
04 24
04 25
05 68
05 69
09 48
09 49
09 47 5
09 47 6
09 47 7
09 47 8
09 47 9
```

## Limitations

If you receive a spam call while already on call, you may hear a notification beep.

The lack of configurability is a _feature_.


## Compatibility

Tested to work on Android 10 (Lineage OS).


## Build

A pre-built apk is included in the repository, available [here](https://github.com/alex14fr/NonMerci/raw/master/NonMerci.apk).

You can also build it yourself, using make, the JDK (javac, keytool), and Android Studio (d8, aapt, apksigner). Tune the settings in the Makefile to fit your system's configuration.


## Author and License

Copyright(c) 2023 Alexandre Janon (alex14fr at gmail dot com)

This program comes with ABSOLUTELY NO WARRANTY. This is free software, and you are welcome
to redistribute it under the conditions of the [GNU GPL v3](LICENSE).

