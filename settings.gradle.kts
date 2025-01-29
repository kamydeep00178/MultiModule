pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
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
include(":presentation")
