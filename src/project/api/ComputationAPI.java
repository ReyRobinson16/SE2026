package project.api;

import project.annotations.ConceptualAPI;

@ConceptualAPI
public interface ComputationAPI {
    String computeResult(int input);
}