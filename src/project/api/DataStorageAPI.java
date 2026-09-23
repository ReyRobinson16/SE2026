package project.api;

import project.annotations.ProcessAPI;

@ProcessAPI
public interface DataStorageAPI {
    // Reads integer stream wrapped inside a general DataSet interface
    DataSet readData(String inputSource);

    // Writes computation results out to storage destination
    WriteResult writeData(String outputDestination, String resultData);
}