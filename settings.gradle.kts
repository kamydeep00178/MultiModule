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
    /*versionCatalogs {
        create("libsMore") {
            from(files("gradle/libs.versions.toml"))
        }
    }*/
}

rootProject.name = "MultiModuleProject"
include(":app")
include(":data")
include(":domain")
include(":features")
include(":core")
include(":core:ui")
include(":features:home")
