package project.api;

public class StorageConfig {
    private final String location;

    public StorageConfig(String location) {
        this.location = location;
    }

    public String getLocation() { return location; }
}