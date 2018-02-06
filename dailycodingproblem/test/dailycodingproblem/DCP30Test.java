package dailycodingproblem;

import org.junit.jupiter.api.Test;

import static dailycodingproblem.DCP30.trap;
import static org.junit.jupiter.api.Assertions.assertEquals;

class DCP30Test {

    @Test
    void trapTest() {
        assertEquals(0, trap(null));
        assertEquals(0, trap(new int[]{1}));
        assertEquals(0, trap(new int[]{1, 2}));
        assertEquals(0, trap(new int[]{1, 1, 1}));
        assertEquals(0, trap(new int[]{2, 1, 1}));
        assertEquals(0, trap(new int[]{1, 1, 2}));
        assertEquals(1, trap(new int[]{2, 1, 2}));
        assertEquals(1, trap(new int[]{2, 1, 3}));
        assertEquals(1, trap(new int[]{3, 1, 2}));
        assertEquals(2, trap(new int[]{3, 0, 2}));
        assertEquals(8, trap(new int[]{3, 0, 1, 3, 0, 5}));
    }
}
