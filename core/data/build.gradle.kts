plugins {
    alias(libs.plugins.epicjb.android.library)
    alias(libs.plugins.epicjb.android.hilt)
    id("kotlinx-serialization")
}

android {
    defaultConfig {
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    namespace = "com.jbarrientos.epicjb.data"
}

dependencies {
    implementation(projects.core.network)
    implementation(projects.core.common)

    implementation(libs.okhttp.logging)
    implementation(libs.retrofit.core)
    implementation(libs.retrofit.kotlin.serialization)
    implementation(libs.moshi)
    implementation(libs.moshi.converter)
}
