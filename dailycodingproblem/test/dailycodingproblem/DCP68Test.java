package dailycodingproblem;

import org.junit.jupiter.api.Test;

import static dailycodingproblem.DCP68.numPairsAttacking;
import static org.junit.jupiter.api.Assertions.assertEquals;

class DCP68Test {

  @Test
  void numPairsAttackingTest() {
    assertEquals(0, numPairsAttacking(new int[][] {}));
    assertEquals(0, numPairsAttacking(new int[][] {{0, 0}}));
    assertEquals(1, numPairsAttacking(new int[][] {{0, 0}, {1, 1}}));
    assertEquals(2, numPairsAttacking(new int[][] {{0, 0}, {1, 1}, {0, 2}}));
    assertEquals(3, numPairsAttacking(new int[][] {{0, 0}, {1, 1}, {0, 2}, {1, 3}}));
    assertEquals(2, numPairsAttacking(new int[][] {{0, 0}, {1, 2}, {2, 2}, {4, 0}}));
  }
}
