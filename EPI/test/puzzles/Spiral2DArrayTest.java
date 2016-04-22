package puzzles;

import com.pholser.junit.quickcheck.ForAll;
import com.pholser.junit.quickcheck.generator.InRange;
import org.junit.contrib.theories.Theories;
import org.junit.contrib.theories.Theory;
import org.junit.runner.RunWith;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import static puzzles.Spiral2DArray.*;

/**
 * Created by pankaj on 4/21/16.
 */
@RunWith(Theories.class)
public class Spiral2DArrayTest {
    @Theory
    public void compare(@ForAll int[][] A) {
        assert spiral(A).equals(spiral1(A));
    }

    @Theory
    public void testGenerateSpiralMatrix(@ForAll @InRange(minInt = 1, maxInt = 1000) int N) {
        final List<Integer> A = spiral(generateSpiralMatrix(N));
        for (int i = 0; i < N * N; i++) assert A.get(i) == i + 1;

        final List<Integer> expected = new Random().ints(N * N).boxed().collect(Collectors.toList());
        final List<Integer> actual = spiral(generateSpiralMatrix1(expected));
        assert expected.equals(actual);
    }
}