package dailycodingproblem;

import dailycodingproblem.DCP21.Interval;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static dailycodingproblem.DCP21.minRooms;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Given an array of time intervals (start, end) for classroom lectures (possibly overlapping), find
 * the minimum number of rooms required.
 */
class DCP21Test {

    @Test
    void minRoomsTest() {
        assertEquals(0, minRooms(null));
        assertEquals(0, minRooms(Collections.emptyList()));
        assertEquals(1, minRooms(Arrays.asList(new Interval(0, 0))));
        assertEquals(1, minRooms(Arrays.asList(new Interval(0, 1), new Interval(1, 2))));
        assertEquals(1, minRooms(Arrays.asList(new Interval(1, 2), new Interval(0, 1))));
        assertEquals(2, minRooms(Arrays.asList(new Interval(1, 2), new Interval(0, 2))));
        assertEquals(
                3, minRooms(Arrays.asList(new Interval(1, 2), new Interval(0, 2), new Interval(1, 3))));
        assertEquals(
                2,
                minRooms(Arrays.asList(new Interval(30, 75), new Interval(0, 50), new Interval(60, 150))));
    }
}
