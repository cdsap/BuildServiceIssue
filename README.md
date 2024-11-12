Repository reproducing the following issue:
```
A problem was found with the configuration of task ':lib2:printProperties' (type 'FooTask').
  - In plugin 'foo.plugin' type 'org.acme.FooTask' property 'referencedService' doesn't have a configured value.

    Reason: This property isn't marked as optional and no value has been configured.

    Possible solutions:
      1. Assign a value to 'referencedService'.
      2. Mark property 'referencedService' as optional.

    For more information, please refer to https://docs.gradle.org/8.9/userguide/validation_problems.html#value_not_set in the Gradle documentation.

```
Build scan: https://ge.solutions-team.gradle.com/s/4t5ntkg6w6dpw


This project applies a plugin defined in an included build that defines a taks with a BuildService:
```java
    // Plugin configuration
    @Override
    public void apply(Project project) {
        project.getGradle().getSharedServices().registerIfAbsent("fooService", ForcedPropertieBuildService.class,
            spec -> {
            });

        project.getTasks().register(
            "printProperties",
            FooTask.class, task -> {
            });

    }
    // Task configuration
    public abstract class FooTask extends DefaultTask {

        @ServiceReference("fooService")
        abstract Property<ForcedPropertieBuildService> getReferencedService();

        @TaskAction
        void run() {
        }
    }
```
The plugin is applied to the modules `:lib` and `:lib2`:
```kotlin
plugins {
    `java-library`
    id("foo.plugin")
}
```
If one of the modules adds an additional plugin dependency like:
```kotlin
plugins {
    `java-library`
    id("foo.plugin")
    id("io.github.cdsap.kotlinprocess") version "0.1.6"
}
```
The error is thrown.

Note that this behavior is not present if the plugin is defined in the convention `buildSrc` folder.

There is an existing workaround where the plugin is defined to the root project but not applied:
```kotlin
plugins {
  id("foo.plugin") apply false
}
```
