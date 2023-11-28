plugins {
    id("com.android.application")
    id("com.google.gms.google-services")
}

android {
    namespace = "com.utsav.booklevoire"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.utsav.booklevoire"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    //implementing viewbinding features

    buildFeatures{
        viewBinding{
            enable=true

        }
    }
}

dependencies {

    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.10.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("androidx.lifecycle:lifecycle-livedata:2.6.2")
    implementation("androidx.lifecycle:lifecycle-viewmodel:2.6.2")
    implementation("androidx.legacy:legacy-support-v4:1.0.0")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    //implementation of navigation
    implementation("androidx.navigation:navigation-fragment:2.7.5")
    implementation("androidx.navigation:navigation-ui:2.7.5")
    implementation("androidx.navigation:navigation-dynamic-features-fragment:2.7.5")

    //implementation of glide for image loading
    implementation ("com.github.bumptech.glide:glide:4.16.0")
    annotationProcessor ("com.github.bumptech.glide:compiler:4.14.2")
    implementation ("com.squareup.picasso:picasso:2.8")

    //firebase implementation
    implementation ("com.google.firebase:firebase-core:21.1.1")
    implementation ("com.google.firebase:firebase-auth:22.3.0")
    implementation ("com.google.firebase:firebase-firestore:24.9.1")
    implementation ("com.google.android.gms:play-services-auth:20.7.0")
    implementation ("androidx.lifecycle:lifecycle-extensions:2.2.0")
    implementation(platform("com.google.firebase:firebase-bom:32.6.0"))
    implementation("com.firebaseui:firebase-ui-auth:8.0.2")

    //implemenation of Room
    implementation("androidx.room:room-runtime:2.6.0")
    annotationProcessor("androidx.room:room-compiler:2.6.0")




}