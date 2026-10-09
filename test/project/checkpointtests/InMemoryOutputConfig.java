package project.checkpointtests;

import java.util.ArrayList;
import java.util.List;
import project.api.ComputeResult;

public class InMemoryOutputConfig {

    private final List<ComputeResult> results = new ArrayList<>();

    public void addResult(ComputeResult result) {
        results.add(result);
    }

    public List<ComputeResult> getResults() {
        return results;
    }
}