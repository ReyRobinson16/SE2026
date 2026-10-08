package project.api;

import java.util.Collections;
import java.util.List;

public class DataStorageAPIImpl implements DataStorageAPI {
    @Override
    public List<Integer> readInputData(String inputSource) {
        return Collections.emptyList();
    }

    @Override
    public boolean writeData(String outputDestination, String resultData) {
        return false;
    }
}