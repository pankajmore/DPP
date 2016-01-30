package puzzles;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static puzzles.PascalTriangle.pascalTriangle;

/**
 * Created by pankaj on 1/30/16.
 */
public class PascalTriangleTest {

    @Test
    public void testPascalTriangle() throws Exception {
        List<List<Integer>> pascalTriangle5 = Arrays.asList(
                Arrays.asList(1),
                Arrays.asList(1, 1),
                Arrays.asList(1, 2, 1),
                Arrays.asList(1, 3, 3, 1),
                Arrays.asList(1, 4, 6, 4, 1));
        assert pascalTriangle(5).equals(pascalTriangle5);

    }
}