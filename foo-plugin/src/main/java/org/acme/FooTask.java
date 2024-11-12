package org.acme;

import org.gradle.api.DefaultTask;
import org.gradle.api.provider.Property;
import org.gradle.api.services.ServiceReference;
import org.gradle.api.tasks.TaskAction;

public abstract class FooTask extends DefaultTask {

    @ServiceReference("fooService")
    abstract Property<ForcedPropertieBuildService> getReferencedService();

    @TaskAction
    void run() {
    }
}
