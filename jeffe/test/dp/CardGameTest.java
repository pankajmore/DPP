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
public class CardGameTest {
    @Test
    public void maxScoreDP() throws Exception {
        Assert.assertEquals(0, CardGame.maxScoreDP(Collections.emptyList()));
        Assert.assertEquals(1, CardGame.maxScoreDP(Collections.singletonList(1)));
        Assert.assertEquals(2, CardGame.maxScoreDP(Arrays.asList(1, 2)));
        Assert.assertEquals(4, CardGame.maxScoreDP(Arrays.asList(1, 2, 3)));
    }

    @Theory
    public void compareMaxScore(@ForAll List<Integer> A) {
        if (A.size() > 20) return;
        long expected = CardGame.maxScore(A);
        long actual = CardGame.maxScoreDP(A);
        Assert.assertEquals(expected, actual);
        Assert.assertEquals(expected, CardGame.maxScoreDP1(A));
    }

    @Theory
    public void compareAgainstGreedy(@ForAll List<Integer> A) {
        Assert.assertTrue(CardGame.maxScoreAgainstGreedy(A) >= CardGame.maxScoreDP(A));
    }
}