plugins {
    `java-library`
    id("foo.lugin")
}

group = "org.acme"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
}

tasks.test {
    useJUnitPlatform()
}