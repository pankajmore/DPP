package utils;

import com.pholser.junit.quickcheck.ForAll;
import org.junit.Test;
import org.junit.contrib.theories.Theories;
import org.junit.contrib.theories.Theory;
import org.junit.runner.RunWith;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static utils.BigNumberMultiplication.multiply;

/** Created by pankaj on 4/2/16. */
@RunWith(Theories.class)
public class BigNumberMultiplicationTest {
  @Test
  public void testMultiply() {
    assert (multiply(Arrays.asList(0), Arrays.asList(-1, 0, 0, 0)).equals(Arrays.asList(0)));
    assert (multiply(Arrays.asList(0), Arrays.asList(1, 0, 0, 0)).equals(Arrays.asList(0)));
    assert (multiply(Arrays.asList(9), Arrays.asList(9)).equals(Arrays.asList(8, 1)));
    assert (multiply(Arrays.asList(9), Arrays.asList(9, 9, 9, 9))
        .equals(Arrays.asList(8, 9, 9, 9, 1)));
    assert (multiply(Arrays.asList(1, 3, 1, 4, 1, 2), Arrays.asList(-1, 3, 1, 3, 3, 3, 2))
        .equals(Arrays.asList(-1, 7, 2, 5, 8, 7, 5, 8, 4, 7, 8, 4)));
    assert (multiply(Arrays.asList(7, 3), Arrays.asList(-3)).equals(Arrays.asList(-2, 1, 9)));
  }

  @Theory
  public void compareWithBigInteger(@ForAll int x, @ForAll int y) {
    List<Integer> expected = multiplyUsingBigInteger(x, y);
    List<Integer> actual = multiplyUsingBigNumber(x, y);
    assert expected.equals(actual);
  }

  private List<Integer> multiplyUsingBigInteger(int x, int y) {
    java.math.BigInteger
        big1 = new BigInteger(String.valueOf(x)),
        big2 = new BigInteger(String.valueOf(y));
    return fromString(big1.multiply(big2).toString());
  }

  private List<Integer> multiplyUsingBigNumber(int x, int y) {
    List<Integer> num1 = fromString(Integer.toString(x)), num2 = fromString(Integer.toString(y));
    return multiply(num1, num2);
  }

  private List<Integer> fromString(String s) {
    List<Integer> l = new ArrayList<>();
    boolean sign = s.charAt(0) == '-';
    if (sign) s = s.substring(1);
    for (char c : s.toCharArray()) l.add(c - '0');
    if (sign) l.set(0, -l.get(0));
    return l;
  }
}
