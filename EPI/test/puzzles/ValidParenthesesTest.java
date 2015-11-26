package puzzles;

import org.junit.Test;

import static puzzles.ValidParentheses.isWellFormed;

public class ValidParenthesesTest {

    @Test
    public void testIsValid() throws Exception {
        assert isWellFormed("");
        assert isWellFormed("()");
        assert isWellFormed("()[]{}");
        assert isWellFormed("[()[]]{}");
        assert isWellFormed("(()[]{()[]{}{}})");
        assert !isWellFormed("([)]");
        assert !isWellFormed("[");
        assert !isWellFormed("(()[]{()[]{})({}})");
    }
}