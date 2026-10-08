import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.Test;
import project.api.ComputationAPIImpl;
import project.api.UserComputeEngineAPIImpl;

public class ComputeEngineIntegrationTest {

    @Test
    public void testComputeEngineIntegration() {
        // Setup initial input [1, 10, 25] with no delimiter specified
        InMemoryInputConfig inputConfig = new InMemoryInputConfig(List.of(1, 10, 25));
        InMemoryOutputConfig outputConfig = new InMemoryOutputConfig();

        // 1. Explicitly instantiate test-only Data Storage (@ProcessAPI)
        InMemoryDataStorageAPI dataStorage = new InMemoryDataStorageAPI(inputConfig, outputConfig);

        // 2. Explicitly instantiate real Computation API (@ConceptualAPI)
        ComputationAPIImpl computationAPI = new ComputationAPIImpl(dataStorage);

        // 3. Explicitly instantiate real User Compute Engine API (@NetworkAPI)
        UserComputeEngineAPIImpl userEngine = new UserComputeEngineAPIImpl(computationAPI, dataStorage);

        // Execute job
        userEngine.configureJob("in-memory-input", "in-memory-output");

        // Validate output (This assertion will fail until the compute engine logic is implemented)
        assertEquals(1, outputConfig.getOutputs().size());
    }
}