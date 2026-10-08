import java.util.ArrayList;
import java.util.List;

public class InMemoryOutputConfig {
    private final List<String> outputs;

    public InMemoryOutputConfig() {
        this.outputs = new ArrayList<>();
    }

    public List<String> getOutputs() {
        return outputs;
    }

    public void writeOutput(String result) {
        this.outputs.add(result);
    }
}