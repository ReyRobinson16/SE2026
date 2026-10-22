
package project.checkpointtests;

import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import project.api.ComputationAPIImpl;
import project.api.ComputeRequest;

public class TestConceptualAPI {

    @Test
    public void testComputationAPI() {

        ComputationAPIImpl api = new ComputationAPIImpl();

        ComputeRequest request = mock(ComputeRequest.class);

        Assertions.assertNotNull(api);
        Assertions.assertNull(api.compute(request));
    }
}
