package project.checkpointtests;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import static org.mockito.Mockito.mock;

import project.api.ComputationAPIImpl;
import project.api.ComputeRequest;

public class TestConceptualAPI {

    @Test
    public void testComputationAPI() {

        // Create a mock request
        ComputeRequest mockRequest = mock(ComputeRequest.class);

        // Explicitly create the real implementation
        ComputationAPIImpl api = new ComputationAPIImpl();

        // Verify the API was created
        Assertions.assertNotNull(api);

        // Call the empty implementation
        // Returning null is expected for Checkpoint 3
        Assertions.assertNull(api.compute(mockRequest));
    }
}
