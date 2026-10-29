
package project.checkpointtests;

import project.api.ComputationAPI;
import project.api.ComputationAPIImpl;
import project.api.DataStorageAPI;
import project.api.DataStorageAPIImpl;
import project.api.JobConfig;
import project.api.UserComputeEngineAPI;
import project.api.UserComputeEngineAPIImpl;

public class ManualTestingFramework {

    public static final String INPUT = "manualTestInput.txt";
    public static final String OUTPUT = "manualTestOutput.txt";

    public static void main(String[] args) {    
        ComputationAPI computation = new ComputationAPIImpl();
        DataStorageAPI storage = new DataStorageAPIImpl();

        UserComputeEngineAPI network =
                new UserComputeEngineAPIImpl(computation, storage);

        JobConfig config = new JobConfig(INPUT, OUTPUT);

        network.startJob(config);
    }
}
