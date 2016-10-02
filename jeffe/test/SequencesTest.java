import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by pankaj on 10/2/16.
 */
public class SequencesTest {
    @Test
    public void testLongestOscillatingSubsequence() throws Exception {
        Assert.assertEquals(2, Sequences.longestOscillatingSubsequence(Arrays.asList(1, 2, 3, 4, 5)));
        Assert.assertEquals(4, Sequences.longestOscillatingSubsequence(Arrays.asList(1, 5, 3, 2, 4)));
        Assert.assertEquals(5, Sequences.longestOscillatingSubsequence(Arrays.asList(5, 3, 4, 1, 2)));
    }
}