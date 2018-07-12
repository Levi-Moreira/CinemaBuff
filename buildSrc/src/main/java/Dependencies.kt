@file:Suppress("unused")

object Versions {

    // Release info
    const val minSdk = 21
    const val targetSdk = 27
    const val compileSdk = 27
    const val versionCode = 1
    const val versionName = "1.0"

    //plugins
    const val androidPlugin = "3.1.3"
    const val kotlin = "1.2.50"
    const val googleServicesPlugin = "4.0.1"
    const val novodaBuild = "0.4.1"
    const val fabric = "1.25.1"
    const val gradleVersion = "0.20.0"
    const val ktlint = "0.19.0"
    const val jacoco = "0.8.0"

    //support lib
    const val supportLibs = "27.1.1"
    const val constraintLayout = "1.1.2"
    const val supportTesting = "1.0.1"
    const val multidex = "1.0.3"

    //rxjava
    const val rxJava2 = "2.1.16"
    const val rxAndroid = "2.0.2"

    //networking
    const val retrofit = "2.4.0"
    const val retrofitGsonConverter = "2.4.0"
    const val retrofitRxJava2CallAdapter = "2.4.0"
    const val gson = "2.8.5"

    //testing
    const val junit = "4.12"
    const val mockito = "2.19.0"
    const val hamcrest = "1.3"
    const val espresso = "3.0.2"
    const val runner = "1.0.2"

    //dagger
    const val dagger = "2.16"

    //firebase
    const val auth = "16.0.2"
    const val database = "16.0.1"
    const val messaging = "17.1.0"
    const val core = "16.0.1"
    const val crash = "16.0.1"

}

object Deps {
    //plugins
    const val androidGradlePlugin = "com.android.tools.build:gradle:${Versions.androidPlugin}"
    const val googlePlayServicesPlugin = "com.google.gms:google-services:${Versions.googleServicesPlugin}"
    const val kotlinPlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
    const val novodaBuildPlugin = "com.novoda:gradle-build-properties-plugin:${Versions.novodaBuild}"
    const val fabricPlugin = "io.fabric.tools:gradle:${Versions.fabric}"
    const val gradleVersionPlugin = "com.github.ben-manes:gradle-versions-plugin:${Versions.gradleVersion}"
    const val ktlint = "com.github.shyiko:ktlint:${Versions.ktlint}"
    const val jacoco = "org.jacoco:org.jacoco.core:${Versions.jacoco}"

    //support library
    const val constraintLayout = "com.android.support.constraint:constraint-layout:${Versions.constraintLayout}"
    const val appCompat = "com.android.support:appcompat-v7:${Versions.supportLibs}"
    const val supportV13 = "com.android.support:support-v13:${Versions.supportLibs}"
    const val animatedVector = "com.android.support:animated-vector-drawable:${Versions.supportLibs}"
    const val supportDesign = "com.android.support:design:${Versions.supportLibs}"
    const val supportV4 = "com.android.support:support-v4:${Versions.supportLibs}"
    const val recyclerView = "com.android.support:recyclerview-v7:${Versions.supportLibs}"
    const val cardView = "com.android.support:cardview-v7:${Versions.supportLibs}"
    const val multidex = "com.android.support:multidex:${Versions.multidex}"

    //networking
    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val retrofitGsonCoverter = "com.squareup.retrofit2:converter-gson:${Versions.retrofitGsonConverter}"
    const val retrofitRxJava2CallAdapter = "com.squareup.retrofit2:adapter-rxjava2:${Versions.retrofitRxJava2CallAdapter}"

    //dagger
    const val dagger = "com.google.dagger:dagger:${Versions.dagger}"
    const val daggerSupport = "com.google.dagger:dagger-android-support:${Versions.dagger}"
    const val daggerCompiler = "com.google.dagger:dagger-compiler:${Versions.dagger}"
    const val daggerProcessor = "com.google.dagger:dagger-android-processor:${Versions.dagger}"

    //rxJava
    const val rxJava2 = "io.reactivex.rxjava2:rxjava:${Versions.rxJava2}"
    const val rxAndroid = "io.reactivex.rxjava2:rxandroid:${Versions.rxAndroid}"

    //firebase
    const val firebaseAuth = "com.google.firebase:firebase-auth:${Versions.auth}"
    const val firebaseDatabase = "com.google.firebase:firebase-database:${Versions.database}"
    const val firebaseCore = "com.google.firebase:firebase-core:${Versions.core}"
    const val firebaseCrash = "com.google.firebase:firebase-crash:${Versions.crash}"
    const val firebaseMessaging = "com.google.firebase:firebase-messaging:${Versions.messaging}"

    //testing
    const val junit = "junit:junit:${Versions.junit}"
    const val mockito = "org.mockito:mockito-core:${Versions.mockito}"
    const val hamcrest = "org.hamcrest:hamcrest-library:${Versions.hamcrest}"
    const val runner = "com.android.support.test:runner:${Versions.runner}"
    const val espresso = "com.android.support.test.espresso:espresso-core:${Versions.espresso}"

    //kotlin
    const val kotlinLibrary = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}"
}