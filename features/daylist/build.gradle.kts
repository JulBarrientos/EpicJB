plugins {
    alias(libs.plugins.epicjb.android.feature)
    alias(libs.plugins.epicjb.android.library.compose)
}

android {
    namespace = "com.jbarrientos.epicjb.daylist"
}

dependencies {
    implementation(projects.core.data)
    implementation(projects.core.common)
    implementation(projects.core.network)
    implementation(projects.core.ui)
    implementation(libs.kotlinx.coroutines.core)
}