package org.acme;

import org.gradle.api.Plugin;
import org.gradle.api.Project;

public class FooPlugin implements Plugin<Project> {

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
}
