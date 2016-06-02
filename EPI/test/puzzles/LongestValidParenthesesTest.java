package puzzles;

import com.pholser.junit.quickcheck.ForAll;
import org.junit.Assert;
import org.junit.Test;
import org.junit.contrib.theories.Theories;
import org.junit.contrib.theories.Theory;
import org.junit.runner.RunWith;

import static puzzles.LongestValidParentheses.longestValidParentheses;
import static puzzles.LongestValidParentheses.longestValidParenthesesUsingStack;

/**
 * Created by pankaj on 3/10/16.
 */
@RunWith(Theories.class)
public class LongestValidParenthesesTest {

    @Test
    public void testLongestValidParentheses() throws Exception {
        Assert.assertEquals("", longestValidParentheses("))(("));
        Assert.assertEquals("((()))", longestValidParentheses("((()))"));
        Assert.assertEquals("(())()", longestValidParentheses("((())()(()("));

        Assert.assertEquals("(())()", longestValidParentheses(")(((())()(()("));
        Assert.assertEquals("(())()", longestValidParentheses("((())()(()("));
        Assert.assertEquals("", longestValidParentheses(")("));
        Assert.assertEquals("()", longestValidParentheses("()"));
        Assert.assertEquals("", longestValidParentheses(""));
        Assert.assertEquals("()()()", longestValidParentheses("()()())"));
    }

    @Test
    public void testLongestValidParenthesesUsingStack() throws Exception {
        Assert.assertEquals("", longestValidParenthesesUsingStack("))(("));
        Assert.assertEquals("((()))", longestValidParenthesesUsingStack("((()))"));
        Assert.assertEquals("(())()", longestValidParenthesesUsingStack("((())()(()("));

        Assert.assertEquals("(())()", longestValidParenthesesUsingStack(")(((())()(()("));
        Assert.assertEquals("(())()", longestValidParenthesesUsingStack("((())()(()("));
        Assert.assertEquals("", longestValidParenthesesUsingStack(")("));
        Assert.assertEquals("()", longestValidParenthesesUsingStack("()"));
        Assert.assertEquals("", longestValidParenthesesUsingStack(""));
        Assert.assertEquals("()()()", longestValidParenthesesUsingStack("()()())"));
    }

    @Theory
    public void testCompare(@ForAll int x) {
        if (x == 0) return;
        String input = generateTestCase(x);
        String expected = longestValidParentheses(input);
        String actual = longestValidParenthesesUsingStack(input);
        Assert.assertEquals("Longest valid parentheses for " + input, expected, actual);
    }

    private String generateTestCase(int x) {
        StringBuilder sb = new StringBuilder();
        while (x != 0) {
            sb.append(x % 2 == 0 ? '(' : ')');
            x >>>= 1;
        }
        return sb.toString();
    }
}