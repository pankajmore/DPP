package puzzles;

import com.pholser.junit.quickcheck.ForAll;
import com.pholser.junit.quickcheck.generator.InRange;
import org.junit.Test;
import org.junit.contrib.theories.Theories;
import org.junit.contrib.theories.Theory;
import org.junit.runner.RunWith;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static puzzles.LongestNonDecreasingSubsequence.*;

/**
 * Created by pankaj on 1/19/16.
 */
@RunWith(Theories.class)
public class LongestNonDecreasingSubsequenceTest {

    @Theory
    public void testCompare(@ForAll @InRange(minInt = -10, maxInt = 10) List<Integer> A) {
        List<Integer> expected = longestNonDecreasingSubSequence(A);
        List<Integer> actual = longestNonDecreasingSubSequenceEfficient(A);
        assertEquals(expected, actual);
    }

    @Test
    public void testLongestNonDecreasingSubSequence() throws Exception {
        assert longestNonDecreasingSubSequence(
                Arrays.asList(0, 8, 4, 12, 2, 10, 6, 14, 1, 9)).equals(
                Arrays.asList(0, 2, 6, 9));
    }

    @Test
    public void testLongestNonDecreasingSubSequenceEfficient() throws Exception {
        assertEquals(Arrays.asList(0, 2, 6, 9), longestNonDecreasingSubSequenceEfficient(
                Arrays.asList(0, 8, 4, 12, 2, 10, 6, 14, 1, 9)));
    }

    @Test
    public void testLongestNonDecreasingSubSequenceLength() throws Exception {
        assert longestNonDecreasingSubSequenceLength(
                Arrays.asList(0, 8, 4, 12, 2, 10, 6, 14, 1, 9)) == 4;
        assert longestNonDecreasingSubSequenceLength(
                Arrays.asList(0, 8, 4, 5, 5, 5, 5, 2, 3, 6)) == 7;
    }
}