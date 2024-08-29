plugins {
    id("java-library")
    alias(libs.plugins.kotlin)
}

dependencies {
    implementation(platform(libs.coroutines.bom))
    implementation(libs.coroutines.core)
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}