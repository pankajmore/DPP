package dailycodingproblem;

import org.junit.jupiter.api.Test;

import static dailycodingproblem.DCP60.canPartition;
import static org.junit.jupiter.api.Assertions.assertEquals;

class DCP60Test {

  @Test
  void canPartitionTest() {
    assertEquals(true, canPartition(new int[] {}));
    assertEquals(true, canPartition(new int[] {0}));
    assertEquals(false, canPartition(new int[] {2}));
    assertEquals(true, canPartition(new int[] {1, 1}));
    assertEquals(false, canPartition(new int[] {2, 3}));
    assertEquals(false, canPartition(new int[] {15, 5, 20, 10, 35}));
    assertEquals(true, canPartition(new int[] {15, 5, 20, 10, 35, 25, 10}));
  }
}
