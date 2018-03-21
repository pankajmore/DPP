package dailycodingproblem;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static dailycodingproblem.DCP73.ListNode.fromList;
import static dailycodingproblem.DCP73.ListNode.toList;
import static dailycodingproblem.DCP73.reverse;
import static org.junit.jupiter.api.Assertions.assertEquals;

class DCP73Test {

  @Test
  void reverseTest() {
    assertEquals(null, toList(reverse(null)));
    assertEquals(null, toList(reverse(fromList(Collections.emptyList()))));
    assertEquals(Collections.singletonList(1), toList(reverse(fromList(Collections.singletonList(1)))));
    assertEquals(Arrays.asList(2, 1), toList(reverse(fromList(Arrays.asList(1, 2)))));
    assertEquals(Arrays.asList(3, 2, 1), toList(reverse(fromList(Arrays.asList(1, 2, 3)))));
  }
}
