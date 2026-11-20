
package threadharness;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import project.api.MultiThreadedUserComputeEngineAPIImpl;
import project.api.UserComputeEngineAPI;

public class TestMultiUser {

    private UserComputeEngineAPI coordinator;

    @BeforeEach
    public void initializeComputeEngine() {
        coordinator = new MultiThreadedUserComputeEngineAPIImpl();
    }

    @Test
    public void compareMultiAndSingleThreaded() throws Exception {
        int threadCount = 4;
        List<TestUser> testUsers = new ArrayList<>();

        for (int i = 0; i < threadCount; i++) {
            testUsers.add(new TestUser(coordinator));
        }

        String singleThreadFilePrefix =
                "testMultiUser.compareMultiAndSingleThreaded.test.singleThreadOut.tmp";

        String multiThreadFilePrefix =
                "testMultiUser.compareMultiAndSingleThreaded.test.multiThreadOut.tmp";

        runSingleThreaded(testUsers, singleThreadFilePrefix);
        runMultiThreaded(testUsers, multiThreadFilePrefix);

        List<String> singleThreaded =
                loadAllOutput(singleThreadFilePrefix, threadCount);

        List<String> multiThreaded =
                loadAllOutput(multiThreadFilePrefix, threadCount);

        Assertions.assertEquals(singleThreaded, multiThreaded);
    }

    private void runSingleThreaded(
            List<TestUser> testUsers,
            String filePrefix) throws IOException {

        for (int i = 0; i < testUsers.size(); i++) {
            File output = new File(filePrefix + i);
            output.deleteOnExit();

            testUsers.get(i).run(output.getCanonicalPath());
        }
    }

    private void runMultiThreaded(
            List<TestUser> testUsers,
            String filePrefix) throws IOException {

        ExecutorService threadPool =
                Executors.newCachedThreadPool();

        List<Future<?>> results = new ArrayList<>();

        for (int i = 0; i < testUsers.size(); i++) {
            File output = new File(filePrefix + i);
            output.deleteOnExit();

            String outputPath = output.getCanonicalPath();
            TestUser testUser = testUsers.get(i);

            results.add(threadPool.submit(
                    () -> testUser.run(outputPath)));
        }

        results.forEach(future -> {
            try {
                future.get();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });

        threadPool.shutdown();
    }

    private List<String> loadAllOutput(
            String prefix, int threadCount) throws IOException {

        List<String> result = new ArrayList<>();

        for (int i = 0; i < threadCount; i++) {
            File output = new File(prefix + i);
            result.addAll(Files.readAllLines(output.toPath()));
        }

        return result;
    }
}
