package dailycodingproblem;

import org.junit.jupiter.api.Test;

import static dailycodingproblem.DCP47.maxProfit;
import static org.junit.jupiter.api.Assertions.assertEquals;

class DCP47Test {

  @Test
  void maxProfitTest() {
    assertEquals(0, maxProfit(null));
    assertEquals(0, maxProfit(new int[] {}));
    assertEquals(0, maxProfit(new int[] {1}));
    assertEquals(0, maxProfit(new int[] {1, 1}));
    assertEquals(1, maxProfit(new int[] {1, 2}));
    assertEquals(2, maxProfit(new int[] {1, 3}));
    assertEquals(2, maxProfit(new int[] {1, 3}));
    assertEquals(0, maxProfit(new int[] {3, 1}));
    assertEquals(5, maxProfit(new int[] {9, 11, 8, 5, 7, 10}));
  }
}
