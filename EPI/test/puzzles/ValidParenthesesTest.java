package puzzles;

import org.junit.Assert;
import org.junit.Test;

import static puzzles.ValidParentheses.isWellFormed;

public class ValidParenthesesTest {

    @Test
    public void testIsValid() throws Exception {
        Assert.assertTrue(isWellFormed(""));
        Assert.assertTrue(isWellFormed("()"));
        Assert.assertTrue(isWellFormed("()[]{}"));
        Assert.assertTrue(isWellFormed("[()[]]{}"));
        Assert.assertTrue(isWellFormed("(()[]{()[]{}{}})"));
        Assert.assertFalse(isWellFormed("([)]"));
        Assert.assertFalse(isWellFormed("["));
        Assert.assertFalse(isWellFormed("(()[]{()[]{})({}})"));
    }
}