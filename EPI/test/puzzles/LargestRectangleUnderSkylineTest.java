package puzzles;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static puzzles.LargestRectangleUnderSkyline.calculateLargestRectangle;

public class LargestRectangleUnderSkylineTest {

    @Test
    public void testCalculateLargestRectangle() throws Exception {
        List<Integer> A = Arrays.asList(2, 3, 4, 1, 2);
        assert calculateLargestRectangle(A) == 6;
    }
}