package project.api;

public class ComputationAPIImpl implements ComputationAPI {

    public ComputationAPIImpl() {
        // Public constructor for smoke test reflection
    }

    @Override
    public ComputeResult compute(ComputeRequest request) {
        return new ComputeResult("Computed: " + request.getInputNumber());
    }
}