package puzzles;

import org.junit.Test;

import java.util.Arrays;

import static puzzles.LongestContainedRange.longestContainedRange;

public class LongestContainedRangeTest {

    @Test
    public void testLongestContainedRange() throws Exception {
        assert longestContainedRange(Arrays.asList(3, -2, 7, 9, 8, 1, 2, 0)) == 4;
    }
}