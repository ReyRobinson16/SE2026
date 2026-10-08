package project.api;

import java.util.List;
import project.annotations.ProcessAPI;

@ProcessAPI
public interface DataStorageAPI {
    List<Integer> readInputData(String inputSource);
    boolean writeData(String outputDestination, String resultData);
}