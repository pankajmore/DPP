package dp;

import com.pholser.junit.quickcheck.ForAll;
import org.junit.Assert;
import org.junit.Test;
import org.junit.contrib.theories.Theories;
import org.junit.contrib.theories.Theory;
import org.junit.runner.RunWith;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by pankaj on 11/5/16.
 */
@RunWith(Theories.class)
public class Q5Test {
    @Test
    public void maxScoreDP() throws Exception {
        Assert.assertEquals(0, Q5.maxScoreDP(Collections.emptyList()));
        Assert.assertEquals(1, Q5.maxScoreDP(Collections.singletonList(1)));
        Assert.assertEquals(2, Q5.maxScoreDP(Arrays.asList(1, 2)));
        Assert.assertEquals(4, Q5.maxScoreDP(Arrays.asList(1, 2, 3)));
    }

    @Theory
    public void compareMaxScore(@ForAll List<Integer> A) {
        if (A.size() > 20) return;
        long expected = Q5.maxScore(A);
        long actual = Q5.maxScoreDP(A);
        Assert.assertEquals(expected, actual);
        Assert.assertEquals(expected, Q5.maxScoreDP1(A));
    }

    @Theory
    public void compareAgainstGreedy(@ForAll List<Integer> A) {
        Assert.assertTrue(Q5.maxScoreAgainstGreedy(A) >= Q5.maxScoreDP(A));
    }
}