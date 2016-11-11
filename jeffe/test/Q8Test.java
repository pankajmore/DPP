import org.junit.Assert;
import org.junit.Test;

/**
 * Created by pankaj on 11/11/16.
 */
public class Q8Test {
    @Test
    public void longestPalindromicSubsequence() throws Exception {
        Assert.assertEquals(0, Q8.longestPalindromicSubsequence(""));
        Assert.assertEquals(1, Q8.longestPalindromicSubsequence("a"));
        Assert.assertEquals(1, Q8.longestPalindromicSubsequence("ab"));
        Assert.assertEquals(3, Q8.longestPalindromicSubsequence("aba"));
        Assert.assertEquals(4, Q8.longestPalindromicSubsequence("abba"));
        Assert.assertEquals(3, Q8.longestPalindromicSubsequence("abab"));
        Assert.assertEquals(4, Q8.longestPalindromicSubsequence("abbaa"));
        Assert.assertEquals(4, Q8.longestPalindromicSubsequence("aabba"));
    }
}