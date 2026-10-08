import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import project.api.DataStorageAPIImpl;

public class TestDataStorageAPI {
    @Test
    public void testDataStorageAPI() {
        DataStorageAPIImpl storage = new DataStorageAPIImpl();
        Assertions.assertNotNull(storage);
    }
}