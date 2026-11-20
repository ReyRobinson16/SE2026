
package threadharness;

import java.io.File;

import project.api.JobConfig;
import project.api.UserComputeEngineAPI;

public class TestUser {

    private final UserComputeEngineAPI coordinator;

    public TestUser(UserComputeEngineAPI coordinator) {
        this.coordinator = coordinator;
    }

    public void run(String outputPath) {
        char delimiter = ';';
        String inputPath = "test" + File.separatorChar
                + "testInputFile.test";

        JobConfig job = new JobConfig(inputPath, outputPath);
        coordinator.startJob(job);
    }
}
