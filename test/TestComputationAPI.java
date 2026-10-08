import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.Test;
import project.api.ComputationAPI;
import project.api.ComputationAPIImpl;
import project.api.DataStorageAPI;

public class TestComputationAPI {

    @Test
    public void testComputationAPI() {
        // Mock dependency
        DataStorageAPI mockDataStorage = mock(DataStorageAPI.class);

        // Explicit constructor call required for static analyzer
        ComputationAPI api = new ComputationAPIImpl(mockDataStorage);

        String result = api.computeResult(10);
        assertNotNull(result);
    }
}