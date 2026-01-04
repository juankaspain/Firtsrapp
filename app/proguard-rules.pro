# ProGuard rules for code obfuscation and optimization
# This file contains ProGuard configuration for the application

# Basic optimization settings
-optimizationpasses 5
-dontusemixedcaseclassnames
-verbose

# Optimization and obfuscation settings
-optimizations !code/simplification/arithmetic,!code/simplification/cast,!field/*,!class/merging/*
-keepattributes *Annotation*
-keepattributes Signature
-keepattributes SourceFile,LineNumberTable
-renamesourcefileattribute SourceFile

# Keep Android framework classes
-keep public class * extends android.app.Activity
-keep public class * extends android.app.Service
-keep public class * extends android.content.BroadcastReceiver
-keep public class * extends android.content.ContentProvider
-keep public class * extends android.app.Fragment
-keep public class * extends androidx.fragment.app.Fragment
-keep public class * extends android.preference.Preference
-keep public class * extends android.view.View

# Keep application classes and their constructors
-keep public class * extends android.app.Application
-keepclasseswithmembernames class * {
    native <methods>;
}

# Keep onClick methods
-keepclasseswithmembers class * {
    public void on*Event(***);
}

# Keep enum constructors and values
-keepclassmembers enum * {
    public static **[] values();
    public static ** valueOf(java.lang.String);
}

# Keep Parcelable implementations
-keep class * implements android.os.Parcelable {
    public static final android.os.Parcelable$Creator *;
}

# Keep Serializable classes
-keepclassmembers class * implements java.io.Serializable {
    static final long serialVersionUID;
    private static final java.io.ObjectStreamField[] serialPersistentFields;
    private void writeObject(java.io.ObjectOutputStream);
    private void readObject(java.io.ObjectInputStream);
    java.lang.Object writeReplace();
    java.lang.Object readResolve();
}

# Keep resource IDs and layout references
-keepclassmembers class **.R$* {
    public static <fields>;
}

# Suppress warnings about missing libraries
-dontwarn android.**
-dontwarn androidx.**
-dontwarn com.google.**
-dontwarn com.android.**

# Remove logging
-assumenosideeffects class android.util.Log {
    public static *** d(...);
    public static *** v(...);
    public static *** i(...);
}

# Keep BuildConfig
-keep class **.BuildConfig { *; }

# Keep R classes
-keepclassmembers class **.R {
    public static <fields>;
}

# Obfuscation settings
-obfuscationdictionary obfuscation-dict.txt
-classobfuscationdictionary class-obfuscation-dict.txt
-packageobfuscationdictionary package-obfuscation-dict.txt

# Keep custom application classes
-keep class * extends android.content.Context
-keep class * extends android.view.ViewGroup
-keep class * extends android.widget.BaseAdapter

# Keep generic signatures
-keepattributes Signature

# Keep InnerClasses attributes
-keepattributes InnerClasses

# Keep EnclosingClass and EnclosingMethod attributes
-keepattributes EnclosingClass, EnclosingMethod

# Database and ORM classes
-keep class * extends androidx.room.RoomDatabase
-keep @androidx.room.* class * { *; }
-keepclassmembers @androidx.room.* class * { *; }

# Retrofit and network libraries
-keepattributes RuntimeVisibleAnnotations
-keepattributes RuntimeInvisibleAnnotations
-keepattributes RuntimeVisibleParameterAnnotations
-keepattributes RuntimeInvisibleParameterAnnotations

# Remove unused code
-dontshrink
