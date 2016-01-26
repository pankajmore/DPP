package puzzles;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static puzzles.SubsetClosestToHalfSum.subsetClosestToHalfSum;

/**
 * Created by pankaj on 1/26/16.
 */
public class SubsetClosestToHalfSumTest {

    @Test
    public void testSubsetClosestToHalfSum() throws Exception {
        List<Integer> set = Arrays.asList(4, 5, 2, 7);
        List<Integer> subset = Arrays.asList(2, 7);
        assert subsetClosestToHalfSum(set).equals(subset);
    }
}