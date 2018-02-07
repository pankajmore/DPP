package dailycodingproblem;

import org.junit.jupiter.api.Test;

import static dailycodingproblem.DCP31.minDistance;
import static org.junit.jupiter.api.Assertions.assertEquals;

class DCP31Test {

    @Test
    void minDistanceTest() {
        assertEquals(0, minDistance("", ""));
        assertEquals(0, minDistance("a", "a"));
        assertEquals(1, minDistance("", "a"));
        assertEquals(1, minDistance("a", ""));
        assertEquals(1, minDistance("a", "b"));
        assertEquals(1, minDistance("aa", "a"));
        assertEquals(1, minDistance("a", "aa"));
        assertEquals(1, minDistance("ab", "aa"));
        assertEquals(1, minDistance("aa", "ab"));
        assertEquals(2, minDistance("ab", "cd"));
        assertEquals(3, minDistance("kitten", "sitting"));
    }
}
