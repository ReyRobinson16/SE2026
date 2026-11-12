
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

        inputNumbers.clear();

        if (config == null
                || config.getInputSource() == null
                || config.getInputSource().isBlank()) {
            return null;
        }

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

            return new InputData(new ArrayList<>(inputNumbers));

        } catch (IOException | RuntimeException e) {
            inputNumbers.clear();
            return null;
        }
    }

    @Override
    public String clearOutput(StorageConfig config) {

        if (config == null
                || config.getOutputDestination() == null
                || config.getOutputDestination().isBlank()) {
            return "ERROR: Invalid output file path";
        }

        try {
            Files.deleteIfExists(
                    Path.of(config.getOutputDestination()));

            return "SUCCESS";

        } catch (IOException | RuntimeException e) {
            return "ERROR: Unable to clear output file";
        }
    }

    @Override
    public String writeData(
            StorageConfig config,
            ComputeResult result) {

        if (config == null
                || config.getOutputDestination() == null
                || config.getOutputDestination().isBlank()
                || result == null
                || result.getOutput() == null) {
            return "ERROR: Invalid output configuration or result";
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

            return "SUCCESS";

        } catch (IOException | RuntimeException e) {
            return "ERROR: Unable to write output file";
        }
    }

    public List<Integer> getInputNumbers() {
        return new ArrayList<>(inputNumbers);
    }

    public ComputeResult getLastResult() {
        return lastResult;
    }
}
