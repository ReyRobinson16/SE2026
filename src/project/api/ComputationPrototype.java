package project.api;

import project.annotations.ConceptualAPIPrototype;

public class ComputationPrototype {
    @ConceptualAPIPrototype
    public void prototypeComputation(ComputationAPI api) {
        api.computeResult(100);
    }
}