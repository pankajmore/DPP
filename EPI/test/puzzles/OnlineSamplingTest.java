package puzzles;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static puzzles.OnlineSampling.randomSubset;

public class OnlineSamplingTest {

    @Test
    public void testRandomSubset() throws Exception {
        int N = 4, K = 2;
        Map<String, Integer> counts = new HashMap<>();
        int numExperiments = 10 * (1 << N * N);
        for (int i = 0; i < numExperiments; i++) {
            String sample = randomSubset(N, K).toString();
            if (!counts.containsKey(sample))
                counts.put(sample, 0);
            counts.put(sample, counts.get(sample) + 1);
        }
        assert counts.size() == 12; //we should get all possible subsets
    }
}