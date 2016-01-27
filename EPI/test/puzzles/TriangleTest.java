package puzzles;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static puzzles.Triangle.minPath;
import static puzzles.Triangle.minPathSum;

/**
 * Created by pankaj on 1/27/16.
 */
public class TriangleTest {
    private List<List<Integer>> triangle = Arrays.asList(Arrays.asList(2), Arrays.asList(3, 4),
            Arrays.asList(6, 5, 7), Arrays.asList(4, 1, 8, 3));

    @Test
    public void testMinPathSum() throws Exception {
        assert 11 == minPathSum(triangle);
    }

    @Test
    public void testMinPath() throws Exception {
        assert Arrays.asList(2, 3, 5, 1).equals(minPath(triangle));
    }
}