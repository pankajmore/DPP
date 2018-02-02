package dailycodingproblem;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static dailycodingproblem.DCP26.Node.fromList;
import static dailycodingproblem.DCP26.Node.toList;
import static dailycodingproblem.DCP26.removeKthLast;
import static org.junit.jupiter.api.Assertions.assertEquals;

class DCP26Test {

    @Test
    void removeKthLastTest() {
        assertEquals(Collections.emptyList(), toList(removeKthLast(fromList(Arrays.asList(1)), 1)));
        assertEquals(Arrays.asList(1), toList(removeKthLast(fromList(Arrays.asList(1, 2)), 1)));
        assertEquals(Arrays.asList(2), toList(removeKthLast(fromList(Arrays.asList(1, 2)), 2)));
        assertEquals(Arrays.asList(1, 2), toList(removeKthLast(fromList(Arrays.asList(1, 2, 3)), 1)));
        assertEquals(Arrays.asList(1, 3), toList(removeKthLast(fromList(Arrays.asList(1, 2, 3)), 2)));
        assertEquals(Arrays.asList(2, 3), toList(removeKthLast(fromList(Arrays.asList(1, 2, 3)), 3)));
    }
}
