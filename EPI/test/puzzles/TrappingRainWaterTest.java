package puzzles;

import org.junit.Test;

public class TrappingRainWaterTest {

  @Test
  public void testCapacity() throws Exception {
    int[] A = {1, 2, 1, 3, 4, 4, 5, 1, 2, 0, 3};
    assert TrappingRainWater.capacity(A) == 7;
    assert TrappingRainWater.capacity1(A) == 7;
  }
}
