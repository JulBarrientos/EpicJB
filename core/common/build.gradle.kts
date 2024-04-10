plugins {
    alias(libs.plugins.epicjb.android.feature)
}

android {
    defaultConfig {
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    namespace = "com.jbarrientos.common"
}

dependencies {
    implementation(libs.kotlinx.coroutines.core)
}