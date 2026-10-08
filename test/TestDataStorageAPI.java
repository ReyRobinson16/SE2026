import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import project.api.DataStorageAPI;
import project.api.DataStorageAPIImpl;

public class TestDataStorageAPI {

    @Test
    public void testDataStorageAPI() {
        // Explicit constructor call required for static analyzer
        DataStorageAPI api = new DataStorageAPIImpl();

        assertNotNull(api.readInputData("testInput"));
    }
}