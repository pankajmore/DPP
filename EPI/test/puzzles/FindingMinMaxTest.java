package puzzles;

import org.junit.Test;
import puzzles.FindingMinMax.MinMax;

import java.util.Arrays;
import java.util.List;

import static puzzles.FindingMinMax.findMinAndMax;

public class FindingMinMaxTest {

    @Test
    public void testFindMinAndMax() throws Exception {
        List<Integer> A = Arrays.asList(-1, 3, -4, 6, 4, 10, 4, 4, 9);
        MinMax<Integer> res = findMinAndMax(A);
        assert (-4 == res.min && 10 == res.max);

        A = Arrays.asList(-1, 3, -4, 6, 4, -12, 4, 4, 9);
        res = findMinAndMax(A);
        assert (-12 == res.min && 9 == res.max);

        A = Arrays.asList(-1, 3, -4);
        res = findMinAndMax(A);
        assert (-4 == res.min && 3 == res.max);
    }
}