pluginManagement {
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
include(":app")
include(":features:daylist")
include(":features:photolist")
include(":features:photoscreen")
include(":core:network")
include(":core:local")
