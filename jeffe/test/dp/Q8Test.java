package dp;

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
        Assert.assertEquals(11, Q8.longestPalindromicSubsequence("MAHDYNAMICPROGRAMZLETMESHOWYOUTHEM"));
    }

    @Test
    public void shortestPalindromicSupersequence() throws Exception {
        Assert.assertEquals(0, Q8.shortestPalindromicSupersequence(""));
        Assert.assertEquals(1, Q8.shortestPalindromicSupersequence("a"));
        Assert.assertEquals(3, Q8.shortestPalindromicSupersequence("ab"));
        Assert.assertEquals(3, Q8.shortestPalindromicSupersequence("aba"));
        Assert.assertEquals(4, Q8.shortestPalindromicSupersequence("abba"));
        Assert.assertEquals(5, Q8.shortestPalindromicSupersequence("abab"));
        Assert.assertEquals(6, Q8.shortestPalindromicSupersequence("abbaa"));
        Assert.assertEquals(6, Q8.shortestPalindromicSupersequence("aabba"));
        Assert.assertEquals(13, Q8.shortestPalindromicSupersequence("TWENTYONE"));
    }

    @Test
    public void minimumPalindromicDecomposition() throws Exception {
        Assert.assertEquals(0, Q8.minimumPalindromicDecomposition(""));
        Assert.assertEquals(1, Q8.minimumPalindromicDecomposition("a"));
        Assert.assertEquals(2, Q8.minimumPalindromicDecomposition("ab"));
        Assert.assertEquals(1, Q8.minimumPalindromicDecomposition("aba"));
        Assert.assertEquals(1, Q8.minimumPalindromicDecomposition("abba"));
        Assert.assertEquals(2, Q8.minimumPalindromicDecomposition("abab"));
        Assert.assertEquals(2, Q8.minimumPalindromicDecomposition("abbaa"));
        Assert.assertEquals(2, Q8.minimumPalindromicDecomposition("aabba"));
        Assert.assertEquals(3, Q8.minimumPalindromicDecomposition("BUBBASEESABANANA"));
    }
}