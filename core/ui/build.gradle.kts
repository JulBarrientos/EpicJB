plugins {
    alias(libs.plugins.epicjb.android.library)
    alias(libs.plugins.epicjb.android.library.compose)
}

android {
    defaultConfig {
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    namespace = "com.jbarrientos.epicjb.ui"
}

dependencies {
    api(libs.compose.material3)
    testImplementation(projects.core.testing)
}
