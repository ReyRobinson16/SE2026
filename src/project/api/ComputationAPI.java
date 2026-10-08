package project.api;

import project.annotations.ConceptualAPI;

@ConceptualAPI
public interface ComputationAPI {
    String compute(int input);
}