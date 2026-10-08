import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import project.api.ComputationAPIImpl;

public class TestComputationAPI {
    @Test
    public void testComputationAPI() {
        ComputationAPIImpl computation = new ComputationAPIImpl();
        Assertions.assertNotNull(computation);
    }
}