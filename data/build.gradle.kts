plugins {
    id("java-library")
    alias(libs.plugins.kotlin)
}

dependencies {
    implementation(project(":domain"))
    implementation(platform(libs.coroutines.bom))
    implementation(libs.coroutines.core)
    implementation(platform(libs.koin.bom))
    implementation(libs.koin.core)
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}