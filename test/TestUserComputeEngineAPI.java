import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import project.api.ComputationAPI;
import project.api.DataStorageAPI;
import project.api.UserComputeEngineAPIImpl;

public class TestUserComputeEngineAPI {
    @Test
    public void testUserComputeEngineAPI() {
        ComputationAPI mockComputation = Mockito.mock(ComputationAPI.class);
        DataStorageAPI mockStorage = Mockito.mock(DataStorageAPI.class);

        UserComputeEngineAPIImpl engine = new UserComputeEngineAPIImpl(mockComputation, mockStorage);
        Assertions.assertNotNull(engine);
    }
}