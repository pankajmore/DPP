package puzzles;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static puzzles.OfflineSampling.sample;

public class OfflineSamplingTest {

    @Test
    public void testSample() throws Exception {
        List<Integer> A = Arrays.asList(0, 1, 2, 3);
        int N = A.size();
        Map<String, Integer> counts = new HashMap<>();
        int numExperiments = 10 * (1 << N * N);
        for (int i = 0; i < numExperiments; i++) {
            String sample = sample(A, 1).toString();
            if (!counts.containsKey(sample))
                counts.put(sample, 0);
            counts.put(sample, counts.get(sample) + 1);
        }
        assert counts.size() == N; //we should get all possible samples
    }
}