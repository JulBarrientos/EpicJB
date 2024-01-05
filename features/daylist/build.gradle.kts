plugins {
    alias(libs.plugins.epicjb.android.feature)
    alias(libs.plugins.epicjb.android.library.compose)
}

android {
    defaultConfig {
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    namespace = "com.jbarrientos.epicjb.daylist"
}

dependencies {
    implementation(libs.hilt.navigation.compose)
}