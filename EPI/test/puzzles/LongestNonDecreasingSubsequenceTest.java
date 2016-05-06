package puzzles;

import org.junit.Test;

import java.util.Arrays;

import static puzzles.LongestNonDecreasingSubsequence.*;
import static puzzles.LongestNonDecreasingSubsequence.longestNonDecreasingSubSequence1;
import static puzzles.LongestNonDecreasingSubsequence.longestNonDecreasingSubSequence1;

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

    @Test
    public void testLongestNonDecreasingSubSequence1() throws Exception {
        assert longestNonDecreasingSubSequence1(
                Arrays.asList(0, 8, 4, 12, 2, 10, 6, 14, 1, 9)).size() == 4;
        assert longestNonDecreasingSubSequence1(
                Arrays.asList(0, 8, 4, 5, 5, 5, 5, 2, 3, 6)).size() == 7;
    }
}