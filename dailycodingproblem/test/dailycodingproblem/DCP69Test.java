package dailycodingproblem;

import org.junit.jupiter.api.Test;

import static dailycodingproblem.DCP69.maximumProduct;
import static org.junit.jupiter.api.Assertions.assertEquals;

class DCP69Test {

  @Test
  void maximumProductTest() {
    assertEquals(0, maximumProduct(new int[] {0, 1, 2}));
    assertEquals(-2, maximumProduct(new int[] {-1, 1, 2}));
    assertEquals(2, maximumProduct(new int[] {-1, -1, 2}));
    assertEquals(500, maximumProduct(new int[] {-10, -10, 5, 2}));
  }
}
