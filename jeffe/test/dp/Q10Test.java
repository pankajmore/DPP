package dp;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

/**
 * Created by pankaj on 15/11/16.
 */
public class Q10Test {
    @Test
    public void largestNonIntersectingSubset() throws Exception {
        Assert.assertEquals(0, Q10.largestNonIntersectingSubset(Collections.emptyList(), Collections.emptyList()));
        Assert.assertEquals(1, Q10.largestNonIntersectingSubset(Collections.singletonList(0), Collections.singletonList(1)));
        Assert.assertEquals(2, Q10.largestNonIntersectingSubset(Arrays.asList(0, 1), Arrays.asList(1, 2)));
        Assert.assertEquals(1, Q10.largestNonIntersectingSubset(Arrays.asList(0, 1), Arrays.asList(1, 0)));
        Assert.assertEquals(2, Q10.largestNonIntersectingSubset(Arrays.asList(0, 1, 2), Arrays.asList(1, 0, 3)));
    }

    @Test
    public void largestIntersectingSubset() throws Exception {
        Assert.assertEquals(0, Q10.largestIntersectingSubset(Collections.emptyList(), Collections.emptyList()));
        Assert.assertEquals(1, Q10.largestIntersectingSubset(Collections.singletonList(0), Collections.singletonList(1)));
        Assert.assertEquals(1, Q10.largestIntersectingSubset(Arrays.asList(0, 1), Arrays.asList(1, 2)));
        Assert.assertEquals(2, Q10.largestIntersectingSubset(Arrays.asList(0, 1), Arrays.asList(1, 0)));
        Assert.assertEquals(3, Q10.largestIntersectingSubset(Arrays.asList(0, 1, 2), Arrays.asList(2, 1, 0)));
        Assert.assertEquals(2, Q10.largestIntersectingSubset(Arrays.asList(0, 1, 2), Arrays.asList(-1, 2, 1)));
    }

}