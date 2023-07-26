@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    alias(libs.plugins.com.android.library)
    alias(libs.plugins.org.jetbrains.kotlin.android)
    alias(libs.plugins.com.google.dagger.hilt)
    kotlin("kapt")
    id("kotlin-parcelize")
}

android {
    namespace = "com.example.network"
    compileSdk = 33

    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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
}

dependencies {
    implementation (project(path = ":domain"))

    implementation (libs.androidx.ktx)
    implementation(libs.core.ktx)
    implementation(libs.appcompat)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.test.ext.junit)
    androidTestImplementation(libs.espresso.core)
    testImplementation(libs.org.jetbrains.kotlinx.test)

    //retrofit
    implementation (libs.squareup.retrofit2)
    implementation (libs.squareup.retrofit2.gson)
    implementation (libs.squareup.retrofit2.moshi)
    implementation (libs.squareup.okhttp3)

    //unit test
    implementation (libs.mockk)
//    implementation (libs.mockito.android)https://github.com/mockito/mockito/issues/3050
    implementation (libs.mockito.core)

    // hilt di
    implementation(libs.hilt)
    kapt(libs.hilt.compiler)
}
kapt {
    correctErrorTypes = true
}