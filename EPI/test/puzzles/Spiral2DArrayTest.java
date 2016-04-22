package puzzles;

import com.pholser.junit.quickcheck.ForAll;
import com.pholser.junit.quickcheck.generator.InRange;
import org.junit.contrib.theories.Theories;
import org.junit.contrib.theories.Theory;
import org.junit.runner.RunWith;

import java.util.List;

import static puzzles.Spiral2DArray.spiral;
import static puzzles.Spiral2DArray.spiral1;

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
        final List<Integer> A = spiral(Spiral2DArray.generateSpiralMatrix(N));
        for (int i = 0; i < N * N; i++) assert A.get(i) == i + 1;
    }
}