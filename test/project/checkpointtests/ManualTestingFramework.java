
package project.checkpointtests;

import project.api.ComputationAPI;
import project.api.ComputationAPIImpl;
import project.api.DataStorageAPI;
import project.api.DataStorageAPIImpl;
import project.api.JobManager;
import project.api.StorageConfig;

public class ManualTestingFramework {

    public static final String INPUT = "manualTestInput.txt";
    public static final String OUTPUT = "manualTestOutput.txt";

    public static void main(String[] args) {
        // TODO 1:
        // Instantiate a real (ie, class definition lives in the src/ folder) implementation
        // of all 3 APIs

        ComputationAPI computation = new ComputationAPIImpl();
        DataStorageAPI storage = new DataStorageAPIImpl();
        JobManager coordinator = new JobManager(computation, storage);

        // TODO 2:
        // Run a computation with an input file of <root project dir>/manualTestInput.txt
        // and an output of <root project dir>/manualTestOutput.txt, with a delimiter of ','

        StorageConfig config = new StorageConfig(INPUT, OUTPUT);
        coordinator.runFileJob(config);

        // Helpful hint: the working directory of this program is <root project dir>,
        // so you can refer to the files just using the INPUT/OUTPUT constants. You do not
        // need to (and should not) actually create those files in your repo
    }
}
