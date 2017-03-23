package puzzles;

import com.pholser.junit.quickcheck.ForAll;
import org.junit.Test;
import org.junit.contrib.theories.Theories;
import org.junit.contrib.theories.Theory;
import org.junit.runner.RunWith;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static puzzles.BiggestProductNMinus1.*;

/** Created by pankaj on 4/12/16. */
@RunWith(Theories.class)
public class BiggestProductNMinus1Test {
  @Test
  public void testFindBiggestProduct() throws Exception {
    assert findBiggestProduct(Collections.emptyList()) == Double.NEGATIVE_INFINITY;
    assert findBiggestProduct(Collections.singletonList(0.0)) == 1.0;
    assert findBiggestProduct(Arrays.asList(0.0, 0.0)) == 0.0;
    assert findBiggestProduct(Arrays.asList(0.0, 0.0)) == 0.0;
    assert findBiggestProduct(Arrays.asList(0.0, -2.0)) == 0.0;
    assert findBiggestProduct(Arrays.asList(0.0, -2.0, -2.0)) == 4.0;
    assert findBiggestProduct(Arrays.asList(0.0, -2.0, -2.0, -3.0)) == 0.0;
    assert findBiggestProduct(Arrays.asList(-1.0)) == 1;
    assert findBiggestProduct(Arrays.asList(-1.0, -2.0)) == -1.0;
    assert findBiggestProduct(Arrays.asList(-1.0, -2.0, -3.0)) == 6.0;
    assert findBiggestProduct(Arrays.asList(2.0)) == 1.0;
    assert findBiggestProduct(Arrays.asList(2.0, 5.0)) == 5.0;
    assert findBiggestProduct(Arrays.asList(2.0, 5.0, 0.5)) == 10.0;
    assert findBiggestProduct(Arrays.asList(2.0, -1.0)) == 2.0;
    assert findBiggestProduct(Arrays.asList(2.0, -1.0, -0.5)) == 0.5;
    assert findBiggestProduct(Arrays.asList(2.0, -1.0, -0.5, -0.1)) == 1.0;
  }

  @Theory
  public void compareWithBruteForce(@ForAll List<Double> A) {
    if (A.isEmpty())
      assert findBiggestProduct(A) == findBiggestProduct1(A)
          && findBiggestProduct(A) == findBiggestProduct2(A);
    else {
      assert Math.abs(findBiggestProduct(A) - findBiggestProduct1(A))
          < 1E-7 * findBiggestProduct(A);
      assert Math.abs(findBiggestProduct(A) - findBiggestProduct2(A))
          < 1E-7 * findBiggestProduct(A);
    }
  }
}
