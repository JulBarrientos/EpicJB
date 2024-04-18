plugins {
    alias(libs.plugins.epicjb.android.library)
    alias(libs.plugins.epicjb.android.library.compose)
    alias(libs.plugins.epicjb.android.hilt)
}

android {
    defaultConfig {
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    namespace = "com.jbarrientos.testing"
}

dependencies {
    api(kotlin("test"))
    api(libs.ui.test.junit4)
    api(projects.core.data)

    debugApi(libs.ui.test.manifest)

    implementation(libs.activity.compose)
    implementation(libs.androidx.test.rules)
    implementation(libs.hilt.android.testing)
    implementation(libs.kotlinx.coroutines.test)
    implementation(libs.kotlinx.datetime)
    implementation(libs.robolectric.shadows)
    implementation(projects.core.common)
}