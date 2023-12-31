@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    alias(libs.plugins.com.android.application)
    alias(libs.plugins.org.jetbrains.kotlin.android)
    alias(libs.plugins.com.google.dagger.hilt)
    kotlin("kapt")
    id("kotlin-parcelize")
}

android {
    namespace = "com.example.cinebase"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.cinebase"
        minSdk = 24
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.3"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation (project(path = ":network"))
    implementation (project(path = ":domain"))

    implementation(libs.androidx.lifecycle.viewmodel.compose)
    implementation(libs.androidx.lifecycle.runtime.compose)
    implementation(libs.core.ktx)
    implementation (libs.androidx.ktx)
    implementation(libs.lifecycle.runtime.ktx)
    implementation(libs.activity.compose)
    implementation(platform(libs.compose.bom))
    implementation(libs.ui)
    implementation(libs.ui.graphics)
    implementation(libs.ui.tooling.preview)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.test.ext.junit)
    androidTestImplementation(libs.espresso.core)
    androidTestImplementation(platform(libs.compose.bom))
    androidTestImplementation(libs.ui.test.junit4)
    debugImplementation(libs.ui.tooling)
    debugImplementation(libs.ui.test.manifest)

    //material 3 and icons compose
    implementation(libs.material3)
    implementation(libs.icons.material)

    //okhttp
    implementation (libs.squareup.okhttp3)
    implementation (libs.squareup.okhttp3.logging)
    implementation (libs.squareup.moshi)
    implementation (libs.squareup.okhttp3.mockwebserver)

    //retrofit
    implementation (libs.squareup.retrofit2.adapter)
    implementation (libs.squareup.retrofit2)
    implementation (libs.squareup.retrofit2.gson)
    implementation (libs.squareup.retrofit2.moshi)

    // hilt di
    implementation(libs.hilt)
    kapt(libs.hilt.compiler)

    // coil to img
    implementation(libs.coil)

    //splash and navigation
    implementation(libs.androidx.navigation.compose)
    implementation(libs.com.airbnb.android.lottie)
}
kapt {
    correctErrorTypes = true
}