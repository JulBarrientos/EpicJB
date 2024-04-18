plugins {
    alias(libs.plugins.epicjb.android.application)
    alias(libs.plugins.epicjb.android.application.compose)
    alias(libs.plugins.epicjb.android.hilt)
}

android {
    defaultConfig {
        applicationId = "com.jbarrientos.epicjb"
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    testOptions {
        unitTests {
            isIncludeAndroidResources = true
        }
    }
    namespace = "com.jbarrientos.epicjb"
}

dependencies {
    implementation(projects.features.daylist)
    implementation(projects.features.photolist)
    implementation(projects.features.photoscreen)

    implementation(projects.core.common)
    implementation(projects.core.ui)

    implementation(libs.androidx.core.splashscreen)
    implementation(libs.core.ktx)
    implementation(libs.activity.compose)
    implementation(platform(libs.compose.bom))
    implementation(libs.ui)
    implementation(libs.ui.graphics)
    implementation(libs.ui.tooling.preview)
    implementation(libs.material3)
    implementation(libs.navigation.compose)

    testImplementation(projects.core.testing)

    androidTestImplementation(projects.core.testing)

    androidTestImplementation(libs.hilt.android.testing)
}
