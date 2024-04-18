pluginManagement {
    includeBuild("build-logic")
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "EpicJB"
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

include(":app")

include(":features:daylist")
include(":features:photolist")
include(":features:photoscreen")

include(":core:network")
include(":core:local")
include(":core:ui")
include(":core:data")
include(":core:common")
include(":core:testing")
