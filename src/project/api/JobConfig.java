package project.api;

public class JobConfig {
    private final String inputSource;
    private final String outputDestination;
    private final char delimiter;

    public JobConfig(String inputSource, String outputDestination, char delimiter) {
        this.inputSource = inputSource;
        this.outputDestination = outputDestination;
        this.delimiter = delimiter;
    }

    public String getInputSource() { return inputSource; }
    public String getOutputDestination() { return outputDestination; }
    public char getDelimiter() { return delimiter; }
}