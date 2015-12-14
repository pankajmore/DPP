package puzzles;

import org.junit.Test;
import utils.Pair;

import java.util.Arrays;

public class StringInMatrixTest {

    @Test
    public void testMatch() throws Exception {
        int[][] A = {
                {1, 2, 3},
                {3, 4, 5},
                {5, 6, 7},
        };
        int[] S = {1, 3, 4, 6};
        assert StringInMatrix.match(A, S).equals(
                Arrays.asList(new Pair<>(0, 0), new Pair<>(1, 0), new Pair<>(1, 1), new Pair<>(2, 1)));
    }
}