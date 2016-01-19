package puzzles;

import org.junit.Test;

import java.util.Arrays;

import static puzzles.LongestNonDecreasingSubsequence.longestNonDecreasingSubSequence;

/**
 * Created by pankaj on 1/19/16.
 */
public class LongestNonDecreasingSubsequenceTest {

    @Test
    public void testLongestNonDecreasingSubSequence() throws Exception {
        assert longestNonDecreasingSubSequence(
                Arrays.asList(0, 8, 4, 12, 2, 10, 6, 14, 1, 9)).equals(
                Arrays.asList(0, 2, 6, 9));
    }
}