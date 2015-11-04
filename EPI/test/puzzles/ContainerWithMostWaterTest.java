package puzzles;

import com.pholser.junit.quickcheck.ForAll;
import org.junit.Test;
import org.junit.contrib.theories.Theories;
import org.junit.contrib.theories.Theory;
import org.junit.runner.RunWith;

import java.util.Arrays;
import java.util.List;

import static puzzles.ContainerWithMostWater.getMaxArea;
import static puzzles.ContainerWithMostWater.getMaxAreaBruteForce;

@RunWith(Theories.class)
public class ContainerWithMostWaterTest {

    @Theory
    public void greedyAndBruteForceShouldMatch(@ForAll List<Integer> heights) {
        for (int i = 0; i < heights.size(); i++) heights.set(i, Math.abs(heights.get(i)) / heights.size());
        assert getMaxArea(heights) == getMaxAreaBruteForce(heights);
    }

    @Test
    public void testBookExample() {
        List<Integer> A
                = Arrays.asList(1, 2, 1, 3, 4, 4, 5, 6, 2, 1, 3, 1, 3, 2, 1, 2, 4, 1);
        assert (48 == getMaxAreaBruteForce(A));
        assert (48 == getMaxArea(A));
    }
}