package dailycodingproblem;

import org.junit.jupiter.api.Test;

import static dailycodingproblem.DCP04.firstMissingPositiveInteger;
import static org.junit.jupiter.api.Assertions.assertEquals;

class DCP04Test {

    @Test
    void firstMissingPositiveIntegerTest() {
        assertEquals(1, firstMissingPositiveInteger(new int[]{}));
        assertEquals(1, firstMissingPositiveInteger(new int[]{-1}));
        assertEquals(1, firstMissingPositiveInteger(new int[]{0}));
        assertEquals(2, firstMissingPositiveInteger(new int[]{1}));

        assertEquals(2, firstMissingPositiveInteger(new int[]{3, 4, -1, 1}));
        assertEquals(3, firstMissingPositiveInteger(new int[]{1, 2, 0}));
    }
}
