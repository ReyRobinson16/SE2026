package project.api;

import project.annotations.ConceptualAPIPrototype;

@ConceptualAPIPrototype
public class ComputationPrototype {
    public void prototypeComputation(ComputationAPI api) {
        api.compute(100);
    }
}