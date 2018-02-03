package dailycodingproblem;

import org.junit.jupiter.api.Test;

import static dailycodingproblem.DCP27.isValid;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class DCP27Test {

    @Test
    void isValidTest() {
        assertTrue(isValid(""));
        assertTrue(isValid("()"));
        assertTrue(isValid("{}"));
        assertTrue(isValid("[]"));
        assertTrue(isValid("()()"));
        assertTrue(isValid("(())"));
        assertTrue(isValid("[()]"));
        assertTrue(isValid("[{}]"));
        assertTrue(isValid("({[]})({})"));
        assertFalse(isValid(")"));
        assertFalse(isValid("}"));
        assertFalse(isValid("]"));
        assertFalse(isValid("("));
        assertFalse(isValid("{"));
        assertFalse(isValid("["));
        assertFalse(isValid(")("));
        assertFalse(isValid("}{"));
        assertFalse(isValid("]["));
    }
}
