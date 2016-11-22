package dp;

import com.pholser.junit.quickcheck.ForAll;
import com.pholser.junit.quickcheck.generator.InRange;
import org.junit.Assert;
import org.junit.Test;
import org.junit.contrib.theories.Theories;
import org.junit.contrib.theories.Theory;
import org.junit.runner.RunWith;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by pankaj on 10/2/16.
 */
@RunWith(Theories.class)
public class Q3Test {
    @Test
    public void shortestOscillatingSupersequence() throws Exception {
        List<Integer> emptyList = Collections.emptyList();
        Assert.assertEquals(0, Q3.shortestOscillatingSupersequence(emptyList));
        Assert.assertEquals(1, Q3.shortestOscillatingSupersequence(Collections.singletonList(1)));
        Assert.assertEquals(2, Q3.shortestOscillatingSupersequence(Arrays.asList(2, 1)));
        Assert.assertEquals(3, Q3.shortestOscillatingSupersequence(Arrays.asList(1, 1)));
        Assert.assertEquals(4, Q3.shortestOscillatingSupersequence(Arrays.asList(2, 1, 1)));
        Assert.assertEquals(5, Q3.shortestOscillatingSupersequence(Arrays.asList(1, 1, 1)));
    }

    @Test
    public void testLongestOscillatingSubsequence() throws Exception {
        Assert.assertEquals(2, Q3.longestOscillatingSubsequence(Arrays.asList(1, 2, 3, 4, 5)));
        Assert.assertEquals(4, Q3.longestOscillatingSubsequence(Arrays.asList(1, 5, 3, 2, 4)));
        Assert.assertEquals(5, Q3.longestOscillatingSubsequence(Arrays.asList(5, 3, 4, 1, 2)));
    }

    @Test
    public void testLongestConvexSubsequence() throws Exception {
        Assert.assertEquals(5, Q3.longestConvexSubsequence(Arrays.asList(1, 2, -1, 0, 3, 8, 5)));
    }

    @Theory
    public void compareLongestConvexSubsequence(@ForAll List<Integer> A) {
        if (A.size() < 20) {
            int expected = Q3.longestConvexSubsequenceSlow(A);
            int actual = Q3.longestConvexSubsequence(A);
            Assert.assertEquals(expected, actual);
        }
    }

    @Theory
    public void compareLongestWeaklyIncreasingSubsequence(@ForAll List<Integer> A) {
        if (A.size() < 20) {
            int expected = Q3.longestWeaklyIncreasingSubsequenceSlow(A);
            int actual = Q3.longestWeaklyIncreasingSubsequence(A);
            Assert.assertEquals(expected, actual);
        }
    }

    @Theory
    public void compareLongestDoubleIncreasingSubsequence(@ForAll List<Integer> A) {
        if (A.size() < 20) {
            int expected = Q3.longestDoubleIncreasingSubsequenceSlow(A);
            int actual = Q3.longestDoubleIncreasingSubsequence(A);
            Assert.assertEquals(expected, actual);
        }
    }

    @Theory
    public void compareLongestCommonIncreasingSubsequence(@ForAll @InRange(minInt = 0, maxInt = 10) List<Integer> A,
                                                          @ForAll @InRange(minInt = 0, maxInt = 10) List<Integer> B) {
        if (A.size() <= 10 && B.size() <= 10) {
            int expected = Q3.longestCommonIncreasingSubsequenceSlow(A, B);
            int actual = Q3.longestCommonIncreasingSubsequence(A, B);
            Assert.assertEquals(expected, actual);
        }
        int expected = Q3.longestCommonIncreasingSubsequence(A, B);
        int actual = Q3.longestCommonIncreasingSubsequence1(A, B);
        Assert.assertEquals(expected, actual);
    }
}