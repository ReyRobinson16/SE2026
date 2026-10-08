import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.Test;
import project.api.ComputationAPI;
import project.api.DataStorageAPI;
import project.api.UserComputeEngineAPI;
import project.api.UserComputeEngineAPIImpl;

public class TestUserComputeEngineAPI {

    @Test
    public void testUserComputeEngineAPI() {
        // Mock dependencies
        ComputationAPI mockComputation = mock(ComputationAPI.class);
        DataStorageAPI mockDataStorage = mock(DataStorageAPI.class);

        // Explicit constructor call required for static analyzer
        UserComputeEngineAPI api = new UserComputeEngineAPIImpl(mockComputation, mockDataStorage);

        String result = api.configureJob("testInput", "testOutput");
        assertNotNull(result);
    }
}