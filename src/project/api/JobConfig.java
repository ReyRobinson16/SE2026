package project.api;

public class JobConfig {

    private final String inputSource;
    private final String outputDestination;

    public JobConfig(String inputSource,
                     String outputDestination) {
        this.inputSource = inputSource;
        this.outputDestination = outputDestination;
    }

    public String getInputSource() {
        return inputSource;
    }

    public String getOutputDestination() {
        return outputDestination;
    }
}