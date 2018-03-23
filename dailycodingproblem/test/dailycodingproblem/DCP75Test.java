package dailycodingproblem;

import org.junit.jupiter.api.Test;

import static dailycodingproblem.DCP75.longesIncreasingSubsequence;
import static org.junit.jupiter.api.Assertions.assertEquals;

class DCP75Test {

  @Test
  void longesIncreasingSubsequenceTest() {
    assertEquals(0, longesIncreasingSubsequence(null));
    assertEquals(0, longesIncreasingSubsequence(new int[] {}));
    assertEquals(1, longesIncreasingSubsequence(new int[] {0}));
    assertEquals(1, longesIncreasingSubsequence(new int[] {0, 0}));
    assertEquals(2, longesIncreasingSubsequence(new int[] {0, 1}));
    assertEquals(2, longesIncreasingSubsequence(new int[] {0, 1, 0}));
    assertEquals(2, longesIncreasingSubsequence(new int[] {1, 0, 2}));
    assertEquals(3, longesIncreasingSubsequence(new int[] {1, 2, 3}));
    assertEquals(4, longesIncreasingSubsequence(new int[] {1, 2, 4, 3, 4}));
    assertEquals(
        6,
        longesIncreasingSubsequence(
            new int[] {0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15}));
  }
}
