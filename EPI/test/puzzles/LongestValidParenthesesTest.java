package puzzles;

import org.junit.Test;

import static org.junit.Assert.*;
import static puzzles.LongestValidParentheses.longestValidParentheses;
import static puzzles.LongestValidParentheses.longestValidParenthesesUsingStack;

/**
 * Created by pankaj on 3/10/16.
 */
public class LongestValidParenthesesTest {

    @Test
    public void testLongestValidParentheses() throws Exception {
        assert longestValidParentheses("))((").equals("");
        assert longestValidParentheses("((()))").equals("((()))");
        assert longestValidParentheses("((())()(()(").equals("(())()");

        assert longestValidParentheses(")(((())()(()(").equals("(())()");
        assert longestValidParentheses("((())()(()(").equals("(())()");
        assert longestValidParentheses(")(").equals("");
        assert longestValidParentheses("()").equals("()");
        assert longestValidParentheses("").equals("");
        assert longestValidParentheses("()()())").equals("()()()");
    }

    @Test
    public void testLongestValidParenthesesUsingStack() throws Exception {
        assert longestValidParenthesesUsingStack("))((").equals("");
        assert longestValidParenthesesUsingStack("((()))").equals("((()))");
        assert longestValidParenthesesUsingStack("((())()(()(").equals("(())()");
    }
}