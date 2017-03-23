package puzzles;

import org.junit.Test;
import org.junit.contrib.theories.Theories;
import org.junit.runner.RunWith;

import static puzzles.BinomialCoefficients.nCk;
import static puzzles.BinomialCoefficients.nCkRecursive;

@RunWith(Theories.class)
public class BinomialCoefficientsTest {

  @Test
  public void nCkTest() {
    assert compareWithTrivial(0, 10);
    assert compareWithTrivial(10, 0);
    assert compareWithTrivial(4, 2);
    assert compareWithTrivial(20, 10);
    assert compareWithTrivial(20, 19);
  }

  private boolean compareWithTrivial(int n, int k) {
    return nCk(n, k) == nCkRecursive(n, k);
  }
}
