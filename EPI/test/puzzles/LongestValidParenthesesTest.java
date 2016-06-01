package puzzles;

import org.junit.Assert;
import org.junit.Test;

import static puzzles.LongestValidParentheses.longestValidParentheses;
import static puzzles.LongestValidParentheses.longestValidParenthesesUsingStack;

/**
 * Created by pankaj on 3/10/16.
 */
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
//        Assert.assertEquals("()()()", longestValidParenthesesUsingStack("()()())")); TODO: fix
    }
}