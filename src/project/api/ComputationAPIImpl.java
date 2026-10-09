package project.api;

public class ComputationAPIImpl implements ComputationAPI {
    public ComputationAPIImpl() {}

    @Override
    public ComputeResult compute(ComputeRequest request) {
        int n = request.getInputNumber();
        return new ComputeResult("Largest prime smaller than " + n);
    }
}