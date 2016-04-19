package puzzles;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static puzzles.NonUniformRandomNumberGeneration.nonUniformRandomNumberGeneration;

/**
 * Created by pankaj on 4/19/16.
 */
public class NonUniformRandomNumberGenerationTest {
    @Test
    public void testNonUniformRandomNumberGeneration() throws Exception {
        List<Integer> values = Arrays.asList(0, 1, 2);
        int N = 3;
        List<Double> probabilities = Arrays.asList(0.2, 0.3, 0.5);
        int kTimes = 100000;
        int[] counts = new int[N];
        for (int i = 0; i < N * kTimes; i++) {
            counts[nonUniformRandomNumberGeneration(values, probabilities)]++;
        }
        for (int i = 0; i < N; i++) {
            assert Math.abs((double) counts[i] / (N * kTimes) - probabilities.get(i)) < 1E-2;
        }
    }

}