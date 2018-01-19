package dailycodingproblem;

import org.junit.jupiter.api.Test;

import static dailycodingproblem.DCP20180118.numWays;
import static org.junit.jupiter.api.Assertions.assertEquals;

class DCP20180118Test {

    @Test
    void numWaysTest() {
        assertEquals(1, numWays(new int[]{1}, 0));
        assertEquals(1, numWays(new int[]{1}, 1));
        assertEquals(1, numWays(new int[]{1}, 2));
        assertEquals(1, numWays(new int[]{1, 2}, 1));
        assertEquals(2, numWays(new int[]{1, 2}, 2));
        assertEquals(3, numWays(new int[]{1, 2}, 3));
        assertEquals(5, numWays(new int[]{1, 2}, 4));
        assertEquals(8, numWays(new int[]{1, 2}, 5));
        assertEquals(5, numWays(new int[]{1, 3, 5}, 5));
    }
}
