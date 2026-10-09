package project.api;

import project.annotations.ConceptualAPI;

@ConceptualAPI
public interface ComputationAPI {
    ComputeResult compute(ComputeRequest request);
}