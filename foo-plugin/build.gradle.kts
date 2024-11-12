import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.dsl.KotlinVersion

plugins {
    `kotlin-dsl`
    id("com.gradle.plugin-publish") version "1.3.0"
    id("maven-publish")
}

repositories {
    mavenCentral()
    mavenLocal()
    gradlePluginPortal()
}

dependencies {
}

val javaLevel: String = libs.versions.javaLevel.get()
val kotlinLevel: String = libs.versions.kotlinLevel.get()

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(javaLevel))
    }
}

kotlin {
    jvmToolchain {
        languageVersion.set(JavaLanguageVersion.of(javaLevel))
    }
    compilerOptions {
        jvmTarget.set(JvmTarget.valueOf("JVM_$javaLevel"))
    }
}
gradlePlugin {
    plugins.create("fooPlugin") {
        id = "foo.plugin"
        implementationClass = "org.acme.FooPlugin"
        displayName = ""
        description = ""
        tags.addAll("")
    }
}
gradlePlugin {
    website.set("https://github.com/")
    vcsUrl.set("https://github.com/quarkusio/quarkus")
}


