package project.api;

import project.annotations.ConceptualAPIPrototype;

public class ComputationPrototype {

    @ConceptualAPIPrototype
    public ComputationResult prototypeComputation(ComputationAPI api) {
        return api.computePrimeMetrics(100);
    }
}