package project.checkpointtests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import project.api.ComputationAPI;
import project.api.ComputationAPIImpl;
import project.api.ComputeRequest;
import project.api.ComputeResult;

public class TestConceptualAPI {
    @Test
    public void testConceptualAPISmoke() {
        ComputationAPI api = new ComputationAPIImpl();
        ComputeRequest request = new ComputeRequest(100);
        ComputeResult result = api.compute(request);
        Assertions.assertNotNull(result);
    }
}