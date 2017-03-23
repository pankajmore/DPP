package puzzles;

import com.pholser.junit.quickcheck.ForAll;
import org.junit.contrib.theories.Theories;
import org.junit.contrib.theories.Theory;
import org.junit.runner.RunWith;

import static puzzles.SwapEvenOddBits.swapEvenOddBits;
import static puzzles.SwapEvenOddBits.swapEvenOddBits1;

/** Created by pankaj on 4/22/16. */
@RunWith(Theories.class)
public class SwapEvenOddBitsTest {
  @Theory
  public void testSwapEvenOddBits(@ForAll int n) throws Exception {
    assert swapEvenOddBits(n) == swapEvenOddBits1(n);
    assert swapEvenOddBits(n) == swapEvenOddBits(n);
    assert swapEvenOddBits1(swapEvenOddBits1(n)) == n;
  }
}
