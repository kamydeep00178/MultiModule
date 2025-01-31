plugins {
    `java-library`
    kotlin("jvm")
    kotlin("kapt")
}
dependencies {
    implementation(libs.kotlin.stdlib)
    implementation(libs.coroutines.core)
    implementation("javax.inject:javax.inject:1")
}

