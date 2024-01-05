plugins {
    alias(libs.plugins.epicjb.android.library)
    alias(libs.plugins.epicjb.android.hilt)
    id("kotlinx-serialization")
    id("com.google.android.libraries.mapsplatform.secrets-gradle-plugin")
}

android {
    defaultConfig {
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    namespace = "com.jbarrientos.epicjb.network"
}

dependencies {
    implementation(libs.retrofit.core)
    implementation(libs.retrofit.kotlin.serialization)
}
