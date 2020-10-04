# firebase-remote-config

Help you to get idea how to config your Android App Remotely and change your App look and feel without updating your App.
For this i using Firebase Remote Config.





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
        
Get Paramter value we can use below code:

firebaseRemoteInstance.get("parameter_name")

firebaseRemoteInstance.getString("parameter_name")

firebaseRemoteInstance.getBoolean("parameter_name")

firebaseRemoteInstance.getString("parameter_name")

firebaseRemoteInstance.getDouble("parameter_name")

firebaseRemoteInstance.getLong("parameter_name")


where "parameter_name" is name of your "Parameter key" which will return value associate to it.

Example:

firebaseRemoteInstance.getString("message") 

where "message" is my parameter name which I have created on Firebase Remote Config, It we give values as a String.




