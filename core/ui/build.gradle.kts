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
    api(libs.ui)
    api(libs.ui.tooling)
    api(libs.ui.graphics)
    testImplementation(projects.core.testing)
}
