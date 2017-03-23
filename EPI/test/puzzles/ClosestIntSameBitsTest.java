package puzzles;

import com.pholser.junit.quickcheck.ForAll;
import com.pholser.junit.quickcheck.generator.InRange;
import org.junit.Test;
import org.junit.contrib.theories.Theories;
import org.junit.contrib.theories.Theory;
import org.junit.runner.RunWith;

import static puzzles.ClosestIntSameBits.*;

/** Created by pankaj on 3/26/16. */
@RunWith(Theories.class)
public class ClosestIntSameBitsTest {

  @Test
  public void testClosestIntSameBits() throws Exception {
    assert closestIntSameBits(1) == 2;
    assert closestIntSameBits(2) == 1;
    assert closestIntSameBits(3) == 5;
    assert closestIntSameBits(4) == 2;
    assert closestIntSameBits(5) == 6;
    assert closestIntSameBits(6) == 5;
  }

  @Theory
  public void testCheckWithBruteForce(
      @ForAll @InRange(minInt = 1, maxInt = Integer.MAX_VALUE - 1) int x) throws Exception {
    assert closestIntSameBits1(x) == closestIntSameBitsBruteForce(x);
    assert closestIntSameBits(x) == closestIntSameBitsBruteForce(x);
  }
}
