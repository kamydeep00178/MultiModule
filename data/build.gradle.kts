plugins {
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.compose)
    alias(libs.plugins.compose.compiler)
    kotlin ("android")
    kotlin("kapt")
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
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.compose.compiler)


    // Hilt Testing
    /*androidTestImplementation(libs.hilt.android.testing.v244)
    kaptAndroidTest(libs.hilt.android.compiler)*/
    //testKapt("com.google.dagger:hilt-android-compiler:2.44")
}