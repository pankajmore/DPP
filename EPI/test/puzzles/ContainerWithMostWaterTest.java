package puzzles;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static puzzles.ContainerWithMostWater.getMaxAreaBruteForce;

public class ContainerWithMostWaterTest {

    @Test
    public void testGetMaxAreaBruteForce() throws Exception {
        List<Integer> A
                = Arrays.asList(1, 2, 1, 3, 4, 4, 5, 6, 2, 1, 3, 1, 3, 2, 1, 2, 4, 1);
        assert (48 == getMaxAreaBruteForce(A));
    }
}