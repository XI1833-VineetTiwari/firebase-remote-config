# firebase-remote-config
Add the below dependency for the Remote config Android library into your app-level module app/build.gradle
//Add this line
apply plugin: 'com.google.gms.google-services'
dependencies {
//Add this line
implementation 'com.google.firebase:firebase-config-ktx:19.2.0'
implementation 'com.google.firebase:firebase-analytics-ktx:17.5.0'
}

Modify your project/build.gradle to the plugin
buildscript {
 repositories {
 google() 
 }
 dependencies {
 // Add this line
 classpath 'com.google.gms:google-services:4.3.4'
 }
}
allprojects {
 repositories {
 google() 
 }
}

fetch() method helps to fetch parameter values from the Remote Config Server and store value in the Remote Config object.
If we want to fetch and activate value in one call then use the fetchAndActivate() method

val firebaseRemoteInstance=FirebaseRemoteConfig.getInstance()
firebaseRemoteInstance.fetch(0)
    .addOnCompleteListener(this) { task ->
        if (task.isSuccessful) {
            firebaseRemoteInstance.fetchAndActivate()
        }
       
    }
