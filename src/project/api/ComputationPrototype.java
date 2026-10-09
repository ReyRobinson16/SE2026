package project.api;

import project.annotations.ConceptualAPIPrototype;

@ConceptualAPIPrototype
public class ComputationPrototype {
    public ComputeResult runPrototype(ComputationAPI api) {
        ComputeRequest request = new ComputeRequest(100);
        return api.compute(request);
    }
}