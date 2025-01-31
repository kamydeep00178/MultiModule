plugins {
    alias(libs.plugins.androidLibrary)
    kotlin ("android")
    kotlin("kapt")
    alias(libs.plugins.hilt)
}

android {
    namespace = "com.lock.data"
    compileSdk = 35

    defaultConfig {
        minSdk = 24
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
    implementation(project(":domain"))
    implementation(libs.hilt.android)
    kapt(libs.hilt.compiler)
    // Retrofit and OkHttp
    implementation(libs.retrofit)
    implementation(libs.retrofit.converter.gson)
    implementation(libs.okhttp)
    implementation(libs.okhttp.logging.interceptor)
}