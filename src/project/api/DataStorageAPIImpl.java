
package project.api;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class DataStorageAPIImpl implements DataStorageAPI {

    private ComputeResult lastResult;
    private final List<Integer> inputNumbers = new ArrayList<>();

    @Override
    public InputData readInputData(StorageConfig config) {

        if (config == null
                || config.getInputSource() == null
                || config.getInputSource().isBlank()) {
            throw new IllegalArgumentException(
                    "Invalid input file path");
        }

        inputNumbers.clear();

        try {
            List<String> lines = Files.readAllLines(
                    Path.of(config.getInputSource()));

            for (String line : lines) {
                for (String value : line.split("[,\\s]+")) {
                    if (!value.isEmpty()) {
                        inputNumbers.add(Integer.parseInt(value));
                    }
                }
            }

        } catch (IOException e) {
            throw new IllegalStateException(
                    "Unable to read input file", e);
        }

        return new InputData(new ArrayList<>(inputNumbers));
    }

    @Override
    public void clearOutput(StorageConfig config) {

        if (config == null
                || config.getOutputDestination() == null
                || config.getOutputDestination().isBlank()) {
            throw new IllegalArgumentException(
                    "Invalid output file path");
        }

        try {
            Files.deleteIfExists(
                    Path.of(config.getOutputDestination()));

        } catch (IOException e) {
            throw new IllegalStateException(
                    "Unable to clear output file", e);
        }
    }

    @Override
    public void writeData(StorageConfig config, ComputeResult result) {

        if (config == null
                || config.getOutputDestination() == null
                || config.getOutputDestination().isBlank()
                || result == null
                || result.getOutput() == null) {
            throw new IllegalArgumentException(
                    "Invalid output configuration or result");
        }

        try {
            Path outputPath =
                    Path.of(config.getOutputDestination());

            String output = result.getOutput();

            if (Files.exists(outputPath)
                    && Files.size(outputPath) > 0) {
                output = "," + output;
            }

            Files.writeString(
                    outputPath,
                    output,
                    StandardOpenOption.CREATE,
                    StandardOpenOption.APPEND);

            lastResult = result;

        } catch (IOException e) {
            throw new IllegalStateException(
                    "Unable to write output file", e);
        }
    }

    public List<Integer> getInputNumbers() {
        return new ArrayList<>(inputNumbers);
    }

    public ComputeResult getLastResult() {
        return lastResult;
    }
}
