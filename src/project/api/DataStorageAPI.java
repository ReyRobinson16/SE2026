package project.api;

import project.annotations.ProcessAPI;
import java.util.List;

@ProcessAPI
public interface DataStorageAPI {
    List<Integer> readInputData(String inputSource);
    boolean writeData(String outputDestination, String resultData);
}