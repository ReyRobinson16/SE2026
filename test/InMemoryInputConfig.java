import java.util.ArrayList;
import java.util.List;

public class InMemoryInputConfig {
    private final List<Integer> inputs;

    public InMemoryInputConfig(List<Integer> inputs) {
        this.inputs = new ArrayList<>(inputs);
    }

    public List<Integer> getInputs() {
        return inputs;
    }
}