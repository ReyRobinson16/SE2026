import java.util.List;
import project.annotations.ProcessAPI;
import project.api.DataStorageAPI;

@ProcessAPI
public class InMemoryDataStorageAPI implements DataStorageAPI {
    private final InMemoryInputConfig inputConfig;
    private final InMemoryOutputConfig outputConfig;

    public InMemoryDataStorageAPI(InMemoryInputConfig inputConfig, InMemoryOutputConfig outputConfig) {
        this.inputConfig = inputConfig;
        this.outputConfig = outputConfig;
    }

    @Override
    public List<Integer> readInputData(String inputSource) {
        return inputConfig.getInputs();
    }

    @Override
    public boolean writeData(String outputDestination, String resultData) {
        outputConfig.writeOutput(resultData);
        return true;
    }

    public InMemoryInputConfig getInputConfig() {
        return inputConfig;
    }

    public InMemoryOutputConfig getOutputConfig() {
        return outputConfig;
    }
}