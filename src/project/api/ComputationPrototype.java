
package project.api;

import project.annotations.ConceptualAPIPrototype;

@ConceptualAPIPrototype
public class ComputationPrototype {

    @ConceptualAPIPrototype
    public ComputeResult prototypeMethod(ComputationAPI api) {
        ComputeRequest request = new ComputeRequest(10);
        return api.compute(request);
    }
}
