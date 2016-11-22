package dp;

import com.pholser.junit.quickcheck.ForAll;
import com.pholser.junit.quickcheck.generator.InRange;
import org.junit.Assert;
import org.junit.Test;
import org.junit.contrib.theories.Theories;
import org.junit.contrib.theories.Theory;
import org.junit.runner.RunWith;

import java.util.Arrays;
import java.util.List;

/**
 * Created by pankaj on 11/4/16.
 */
@RunWith(Theories.class)
public class Q4Test {
    @Test
    public void numberOfSubsequences() throws Exception {
        Assert.assertEquals(1, Q4.numberOfSubsequences(Arrays.asList(), Arrays.asList()));
        Assert.assertEquals(1, Q4.numberOfSubsequences(Arrays.asList(1), Arrays.asList()));
        Assert.assertEquals(0, Q4.numberOfSubsequences(Arrays.asList(), Arrays.asList(1)));

        Assert.assertEquals(1, Q4.numberOfSubsequences(Arrays.asList(1), Arrays.asList(1)));
        Assert.assertEquals(3, Q4.numberOfSubsequences(Arrays.asList(1, 1, 1), Arrays.asList(1)));
        Assert.assertEquals(6, Q4.numberOfSubsequences(Arrays.asList(1, 1, 1, 1), Arrays.asList(1, 1)));
    }

    @Theory
    public void compareNumberOfSubsequences(@ForAll @InRange(minInt = 1, maxInt = 2) List<Integer> A,
                                            @ForAll @InRange(minInt = 1, maxInt = 2) List<Integer> B) {
        if (A.size() >= 20 || B.size() > A.size()) return;
        int expected = Q4.numberOfSubsequencesSlow(A, B);
        int actual = Q4.numberOfSubsequences(A, B);
        Assert.assertEquals(expected, actual);
    }

}