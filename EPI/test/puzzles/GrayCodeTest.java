package puzzles;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static puzzles.GrayCode.grayCode;

public class GrayCodeTest {

  @Test
  public void testGrayCode() throws Exception {
    assert grayCode(1).equals(Arrays.asList(0, 1));
    assert grayCode(2).equals(Arrays.asList(0, 1, 3, 2));
    assert grayCode(3).equals(Arrays.asList(0, 1, 3, 2, 6, 7, 5, 4));

    for (int i = 1; i < 20; i++) assert checkGrayCodeSequence(grayCode(i));
  }

  private boolean checkGrayCodeSequence(List<Integer> sequence) {
    for (int i = 1; i < sequence.size(); i++)
      if (numDifferentBits(sequence.get(i), sequence.get(i - 1)) != 1) return false;
    return true;
  }

  private int numDifferentBits(int x, int y) {
    int d = x ^ y; //1s where bits differ else 0
    int countOnes = 0;
    while (d != 0) {
      countOnes++;
      d &= d - 1;
    }
    return countOnes;
  }
}
