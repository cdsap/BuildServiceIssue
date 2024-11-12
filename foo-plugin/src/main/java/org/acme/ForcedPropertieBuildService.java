package org.acme;

import org.gradle.api.services.BuildService;
import org.gradle.api.services.BuildServiceParameters;

public abstract class ForcedPropertieBuildService implements BuildService<BuildServiceParameters.None> {

    public ForcedPropertieBuildService() {
    }
}
