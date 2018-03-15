package dailycodingproblem;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DCP61Test {

  @Test
  void powTest() {
    assertEquals(1, DCP61.pow(2, 0));
    assertEquals(2, DCP61.pow(2, 1));
    assertEquals(4, DCP61.pow(2, 2));
    assertEquals(8, DCP61.pow(2, 3));
    assertEquals(32, DCP61.pow(2, 5));
    assertEquals(1024, DCP61.pow(2, 10));
  }
}
