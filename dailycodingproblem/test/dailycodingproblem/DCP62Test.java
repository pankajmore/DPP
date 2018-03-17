package dailycodingproblem;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static dailycodingproblem.DCP62.numWays;

class DCP62Test {

  @Test
  void numWaysTest() {
    Assertions.assertEquals(0, numWays(0, 0));
    Assertions.assertEquals(0, numWays(0, 1));
    Assertions.assertEquals(0, numWays(1, 0));
    Assertions.assertEquals(1, numWays(1, 1));
    Assertions.assertEquals(1, numWays(1, 2));
    Assertions.assertEquals(1, numWays(2, 1));
    Assertions.assertEquals(2, numWays(2, 2));
    Assertions.assertEquals(3, numWays(2, 3));
    Assertions.assertEquals(70, numWays(5, 5));
  }
}