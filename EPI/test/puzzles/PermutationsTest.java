package puzzles;

import org.junit.Test;

import java.util.Arrays;

import static puzzles.Permutations.allPermutations;
import static puzzles.Permutations.nextPermutation;

public class PermutationsTest {

    @Test
    public void testAllPermutations() throws Exception {
        allPermutations(Arrays.asList(1, 2, 3), System.out);

        assert allPermutations(Arrays.asList(1)).equals(
                Arrays.asList(
                        Arrays.asList(1)
                ));
        assert allPermutations(Arrays.asList(1, 2, 3)).equals(
                Arrays.asList(
                        Arrays.asList(1, 2, 3),
                        Arrays.asList(1, 3, 2),
                        Arrays.asList(2, 1, 3),
                        Arrays.asList(2, 3, 1),
                        Arrays.asList(3, 1, 2),
                        Arrays.asList(3, 2, 1)
                ));
    }

    @Test
    public void testNextPermutation() throws Exception {
        assert nextPermutation(Arrays.asList(3, 2, 1)) == null;
    }
}