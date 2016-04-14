package puzzles;

import com.pholser.junit.quickcheck.ForAll;
import org.junit.contrib.theories.Theories;
import org.junit.contrib.theories.Theory;
import org.junit.runner.RunWith;
import puzzles.SubseqCover.SubArray;

import java.util.List;

import static puzzles.LongestIncreasingSubarray.findLongestIncreasingSubarray;
import static puzzles.LongestIncreasingSubarray.findLongestIncreasingSubarray1;
import static puzzles.LongestIncreasingSubarray.findLongestIncreasingSubarray2;

/**
 * Created by pankaj on 4/14/16.
 */
@RunWith(Theories.class)
public class LongestIncreasingSubarrayTest {
    @Theory
    public void compareWithBruteForce(@ForAll(sampleSize = 1000) List<Integer> A) {
        SubArray expected = findLongestIncreasingSubarray1(A);
        SubArray actual = findLongestIncreasingSubarray(A);
        SubArray actual2 = findLongestIncreasingSubarray2(A);
        assert actual.equals(expected) && actual2.equals(expected);
    }
}