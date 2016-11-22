package dp;

import org.junit.Assert;
import org.junit.Test;

import java.util.function.Function;

/**
 * Created by pankaj on 14/11/16.
 */
public class Q9Test {
    @Test
    public void maxQualityDecomposition() throws Exception {
        Function<String, Integer> palindrome = (s) -> new StringBuilder(s).reverse().toString().equals(s) ? s.length() : 0;
        Assert.assertEquals(0, Q9.maxQualityDecomposition("", palindrome));
        Assert.assertEquals(1, Q9.maxQualityDecomposition("a", palindrome));
        Assert.assertEquals(2, Q9.maxQualityDecomposition("ab", palindrome));
        Assert.assertEquals(1, Q9.maxQualityDecomposition("aba", palindrome));
        Assert.assertEquals(1, Q9.maxQualityDecomposition("abba", palindrome));
        Assert.assertEquals(2, Q9.maxQualityDecomposition("abab", palindrome));
        Assert.assertEquals(2, Q9.maxQualityDecomposition("abbaa", palindrome));
        Assert.assertEquals(2, Q9.maxQualityDecomposition("aabba", palindrome));
        Assert.assertEquals(3, Q9.maxQualityDecomposition("BUBBASEESABANANA", palindrome));
    }
}