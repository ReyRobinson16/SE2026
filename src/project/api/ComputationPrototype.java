package project.api;

import project.annotations.ConceptualAPIPrototype;

@ConceptualAPIPrototype
public class ComputationPrototype {

    @ConceptualAPIPrototype
    public ComputeResult prototypeMethod(ComputationAPI api, ComputeRequest request) {
        return api.compute(request);
    }
}