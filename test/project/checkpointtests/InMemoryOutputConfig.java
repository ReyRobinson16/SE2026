package project.checkpointtests;

import java.util.ArrayList;
import java.util.List;

public class InMemoryOutputConfig {
    private final List<String> outputs = new ArrayList<>();

    public void writeOutput(String data) {
        outputs.add(data);
    }

    public List<String> getOutputs() {
        return outputs;
    }
}