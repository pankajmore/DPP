package puzzles;

import com.pholser.junit.quickcheck.ForAll;
import org.junit.contrib.theories.Theories;
import org.junit.contrib.theories.Theory;
import org.junit.runner.RunWith;

/** Created by pankaj on 3/31/16. */
@RunWith(Theories.class)
public class DivideTest {

  @Theory
  public void divide(@ForAll int dividend, @ForAll int divisor) throws Exception {
    try {
      int q = Divide.divide(dividend, divisor);
      assert q == dividend / divisor;
    } catch (ArithmeticException e) {
      assert divisor == 0;
    }
  }

  @Theory
  public void divide1(@ForAll int dividend, @ForAll int divisor) throws Exception {
    try {
      int q = Divide.divide1(dividend, divisor);
      assert q == dividend / divisor;
    } catch (ArithmeticException e) {
      assert divisor == 0;
    }
  }
}
