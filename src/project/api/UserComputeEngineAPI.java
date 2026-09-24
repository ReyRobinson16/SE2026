package project.api;

import project.annotations.NetworkAPI;

@NetworkAPI
public interface UserComputeEngineAPI {
    String configureJob(String inputSource, String outputDestination, char delimiter);
    String configureJob(String inputSource, String outputDestination);
}