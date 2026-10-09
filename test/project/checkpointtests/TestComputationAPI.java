package project.checkpointtests;

import project.api.ComputationAPI;
import project.api.ComputeRequest;
import project.api.ComputeResult;

public class TestComputationAPI implements ComputationAPI {
    @Override
    public ComputeResult compute(ComputeRequest request) {
        return new ComputeResult("TestOutput:" + request.getInputNumber());
    }
}