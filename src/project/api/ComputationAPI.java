package project.api;

import project.annotations.ConceptualAPI;

@ConceptualAPI
public interface ComputationAPI {
    ComputationResult computePrimeMetrics(int n);
}