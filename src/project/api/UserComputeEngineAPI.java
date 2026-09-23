package project.api;

import project.annotations.NetworkAPI;

@NetworkAPI
public interface UserComputeEngineAPI {
    // 1. General sources/destinations (String descriptors for local files, DBs, S3, etc.)
    // 2. Custom output delimiter option
    JobConfigResult configureJob(String inputSource, String outputDestination, char delimiter);

    // 2. Overloaded method allowing the user to opt for default delimiters
    JobConfigResult configureJob(String inputSource, String outputDestination);
}