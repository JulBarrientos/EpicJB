plugins {
    alias(libs.plugins.epicjb.android.library)
}

android {
    defaultConfig {
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    namespace = "com.jbarrientos.epicjb.local"
}

dependencies {
    implementation(projects.core.common)

    testImplementation(projects.core.testing)
}
