import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by pankaj on 10/2/16.
 */
public class SequencesTest {
    @Test
    public void shortestOscillatingSupersequence() throws Exception {
        List<Integer> emptyList = Collections.emptyList();
        Assert.assertEquals(0, Sequences.shortestOscillatingSupersequence(emptyList));
        Assert.assertEquals(1, Sequences.shortestOscillatingSupersequence(Collections.singletonList(1)));
        Assert.assertEquals(2, Sequences.shortestOscillatingSupersequence(Arrays.asList(2, 1)));
        Assert.assertEquals(3, Sequences.shortestOscillatingSupersequence(Arrays.asList(1, 1)));
        Assert.assertEquals(4, Sequences.shortestOscillatingSupersequence(Arrays.asList(2, 1, 1)));
        Assert.assertEquals(5, Sequences.shortestOscillatingSupersequence(Arrays.asList(1, 1, 1)));
    }

    @Test
    public void testLongestOscillatingSubsequence() throws Exception {
        Assert.assertEquals(2, Sequences.longestOscillatingSubsequence(Arrays.asList(1, 2, 3, 4, 5)));
        Assert.assertEquals(4, Sequences.longestOscillatingSubsequence(Arrays.asList(1, 5, 3, 2, 4)));
        Assert.assertEquals(5, Sequences.longestOscillatingSubsequence(Arrays.asList(5, 3, 4, 1, 2)));
    }

    @Test
    public void testLongestConvexSubsequence() throws Exception {
        Assert.assertEquals(5, Sequences.longestConvexSubsequence(Arrays.asList(1, 2, -1, 0, 3, 8, 5)));
    }
}