package project.api;

import project.annotations.ConceptualAPIPrototype;

@ConceptualAPIPrototype
public class ComputationPrototype {

    @ConceptualAPIPrototype
    public ComputeResult runPrototype(ComputationAPI api, ComputeRequest request) {
        return api.compute(request);
    }
}