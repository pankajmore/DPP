package puzzles;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static puzzles.PascalTriangle.*;

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
        List<List<Integer>> actual = pascalTriangle(5);
        assert actual.equals(pascalTriangle5);

        for (int i = 1; i < 5; i++) {
            assert getNthRow(i).equals(pascalTriangle5.get(i - 1));
            assert getNthRow(i).equals(getNthRow1(i));
        }
    }
}