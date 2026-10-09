package project.api;

import project.annotations.ConceptualAPIPrototype;

@ConceptualAPIPrototype
public class ComputationPrototype {

    @ConceptualAPIPrototype
    public ComputeResult prototypeMethod(ComputationAPI api) {
        ComputeRequest request = null;
        return api.compute(request);
    }
}