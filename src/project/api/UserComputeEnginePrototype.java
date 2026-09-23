package project.api;

import project.annotations.NetworkAPIPrototype;

public class UserComputeEnginePrototype {

    @NetworkAPIPrototype
    public JobConfigResult prototypeUserComputeEngine(UserComputeEngineAPI api) {
        // Prototype with custom delimiter
        api.configureJob("s3://bucket/input.txt", "db://output-table", ',');
        // Prototype with default delimiter
        return api.configureJob("local/file.csv", "local/output.csv");
    }
}