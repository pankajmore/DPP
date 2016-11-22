package dp;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

/**
 * Created by pankaj on 08/11/16.
 */
public class Q6Test {
    @Test
    public void maxScore() throws Exception {
        Assert.assertEquals(0, Q6.maxScore(Collections.emptyList(), Collections.emptyList()));
        Assert.assertEquals(1, Q6.maxScore(Collections.singletonList(1), Collections.singletonList(0)));
        Assert.assertEquals(3, Q6.maxScore(Arrays.asList(1, 2), Arrays.asList(0, 0)));
        Assert.assertEquals(2, Q6.maxScore(Arrays.asList(1, 2), Arrays.asList(1, 0)));
        Assert.assertEquals(2, Q6.maxScore(Arrays.asList(2, 1), Arrays.asList(1, 0)));
    }
}