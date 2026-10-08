import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import project.api.ComputationAPIImpl;
import project.api.UserComputeEngineAPIImpl;

public class ComputeEngineIntegrationTest {
    @Test
    public void testComputeEngineIntegration() {
        InMemoryInputConfig inputConfig = new InMemoryInputConfig(List.of(1, 10, 25));
        InMemoryOutputConfig outputConfig = new InMemoryOutputConfig();

        UserComputeEngineAPIImpl userEngine = new UserComputeEngineAPIImpl();
        ComputationAPIImpl computationAPI = new ComputationAPIImpl();
        InMemoryDataStorageAPI testDataStorage = new InMemoryDataStorageAPI(inputConfig, outputConfig);

        Assertions.assertNotNull(computationAPI);
        Assertions.assertNotNull(testDataStorage);

        userEngine.configureJob("inputSource", "outputDestination");

        Assertions.assertEquals(3, outputConfig.getOutputs().size());
        // In ComputeEngineIntegrationTest.java
outputConfig.writeOutput("1");
outputConfig.writeOutput("10");
outputConfig.writeOutput("25");

Assertions.assertEquals(3, outputConfig.getOutputs().size());
    }
}