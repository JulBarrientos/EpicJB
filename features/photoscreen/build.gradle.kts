plugins {
    alias(libs.plugins.epicjb.android.feature)
    alias(libs.plugins.epicjb.android.library.compose)
}

android {
    defaultConfig {
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    namespace = "com.jbarrientos.epicjb.photoscreen"
}

dependencies {
    implementation(projects.core.data)
    implementation(projects.core.common)
    implementation(projects.core.network)
    implementation(projects.core.ui)

    implementation(libs.kotlinx.coroutines.core)
    implementation(libs.ui.tooling.preview)
    testImplementation(projects.core.testing)
}
