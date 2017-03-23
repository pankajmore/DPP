package puzzles;

import org.junit.Test;

import static puzzles.MonotonicDecimals.*;

public class MonotonicDecimalsTest {

  @Test
  public void testNumberOfMonotonicDecimals() throws Exception {
    assert numberOfMonotonicDecimals(0) == 0;
    assert numberOfMonotonicDecimals(1) == 9;
    assert numberOfMonotonicDecimals(2) == 45;

    for (int length = 1; length < 9; length++)
      assert numberOfMonotonicDecimals(length) == monotonicDecimalsRecursive(length).size();
  }

  @Test
  public void testNumberOfStrictlyMonotonicDecimals() throws Exception {
    assert numberOfStrictlyMonotonicDecimals(0) == 0;
    assert numberOfStrictlyMonotonicDecimals(1) == 9;
    assert numberOfStrictlyMonotonicDecimals(2) == 36;

    for (int length = 1; length < 9; length++) {
      int actual = numberOfStrictlyMonotonicDecimals(length);
      int expected = strictlyMonotonicDecimalsRecursive(length).size();
      assert expected == actual;
    }
  }
}
