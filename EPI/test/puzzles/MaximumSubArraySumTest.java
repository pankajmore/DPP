package puzzles;

import org.junit.Test;
import puzzles.SubseqCover.SubArray;

import java.util.Arrays;

import static puzzles.MaximumSubArraySum.findMaximumSumSubArray;

/**
 * Created by pankaj on 1/16/16.
 */
public class MaximumSubArraySumTest {

    @Test
    public void testFindMaximumSumSubArray() throws Exception {

        assert findMaximumSumSubArray(Arrays.asList()).equals(new SubArray(0, 0));
        assert findMaximumSumSubArray(Arrays.asList(0, 1, 2)).equals(new SubArray(0, 3));
        assert findMaximumSumSubArray(Arrays.asList(-1, -3, -5)).equals(new SubArray(0, 0));
        assert findMaximumSumSubArray(Arrays.asList(904, 40, 523, 12, -355, -385, -124, 481, -31)).equals(new SubArray(0, 4));
        assert findMaximumSumSubArray(Arrays.asList(1, -2, 1, 3, -4, 2)).equals(new SubArray(2, 4));
    }
}