package project.checkpointtests;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import project.api.ComputationAPIImpl;
import project.api.JobConfig;
import project.api.UserComputeEngineAPIImpl;

public class ComputeEngineIntegrationTest {

    @Test
    public void testComputeEngineIntegration() {
        InMemoryInputConfig inputConfig = new InMemoryInputConfig(List.of(1, 10, 25));
        InMemoryOutputConfig outputConfig = new InMemoryOutputConfig();

        UserComputeEngineAPIImpl userEngine = new UserComputeEngineAPIImpl();
        ComputationAPIImpl computationAPI = new ComputationAPIImpl();
        InMemoryDataStorageAPI testDataStorage = new InMemoryDataStorageAPI(inputConfig, outputConfig);

        Assertions.assertNotNull(userEngine);
        Assertions.assertNotNull(computationAPI);
        Assertions.assertNotNull(testDataStorage);

        outputConfig.writeOutput("result1");
        outputConfig.writeOutput("result2");
        outputConfig.writeOutput("result3");

        JobConfig config = new JobConfig("inputSource", "outputDestination", ';');
        String result = userEngine.configureJob(config);
        Assertions.assertNotNull(result);
    }
}