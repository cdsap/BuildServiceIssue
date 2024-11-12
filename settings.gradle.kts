pluginManagement {
    includeBuild("foo-plugin")
    repositories {
        gradlePluginPortal()
        mavenCentral()
        mavenLocal()
    }
}
plugins {
    id("dev.aga.gradle.version-catalog-generator") version ("2.1.1")
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.8.0"
    id("com.gradle.develocity") version "3.18.1"
}
develocity {
    server = "https://ge.solutions-team.gradle.com/"
    allowUntrustedServer = true
    buildScan {
        uploadInBackground.set(true)
        publishing { true}
    }
}

rootProject.name = "BuildServiceIssue"
include("lib2")
include("lib1")
dependencyResolutionManagement {
    repositories {
        mavenCentral()
        mavenLocal()
    }
}
