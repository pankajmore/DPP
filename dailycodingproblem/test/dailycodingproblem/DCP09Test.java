package dailycodingproblem;

import org.junit.jupiter.api.Test;

import static dailycodingproblem.DCP09.largestSumNonAdjacent;
import static org.junit.jupiter.api.Assertions.assertEquals;

class DCP09Test {

    @Test
    void largestSumNonAdjacentTest() {
        assertEquals(0, largestSumNonAdjacent(new int[]{}));
        assertEquals(1, largestSumNonAdjacent(new int[]{1}));
        assertEquals(2, largestSumNonAdjacent(new int[]{1, 2}));
        assertEquals(2, largestSumNonAdjacent(new int[]{2, 1}));
        assertEquals(4, largestSumNonAdjacent(new int[]{1, 2, 3}));
        assertEquals(3, largestSumNonAdjacent(new int[]{1, 3, 1}));
        assertEquals(6, largestSumNonAdjacent(new int[]{4, 2, 1, 2}));
        assertEquals(12, largestSumNonAdjacent(new int[]{2, 4, 6, 8}));
        assertEquals(10, largestSumNonAdjacent(new int[]{5, 1, 1, 5}));
    }
}
