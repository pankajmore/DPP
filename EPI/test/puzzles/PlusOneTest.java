package puzzles;

import com.pholser.junit.quickcheck.ForAll;
import org.junit.contrib.theories.Theories;
import org.junit.contrib.theories.Theory;
import org.junit.runner.RunWith;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@RunWith(Theories.class)
public class PlusOneTest {

  @Theory
  public void testPlusOne(@ForAll BigInteger x) throws Exception {
    x = x.abs();
    List<Integer> in = convertBigIntegerToList(x);
    List<Integer> in1 = new ArrayList<>(in);
    assert PlusOne.plusOne(in).equals(plusOneUsingBigInteger(in1));
  }

  private List<Integer> convertBigIntegerToList(BigInteger b) {
    ArrayList<Integer> res = new ArrayList<>();
    String r = b.toString();
    for (int i = 0; i < r.length(); i++) {
      res.add(Integer.parseInt(String.valueOf(r.charAt(i))));
    }
    return res;
  }

  private List<Integer> plusOneUsingBigInteger(List<Integer> A) {
    StringBuilder s = new StringBuilder();
    for (Integer x : A) s.append(x);
    BigInteger bigInteger = new BigInteger(s.toString());
    bigInteger = bigInteger.add(new BigInteger("1"));
    ArrayList<Integer> res = new ArrayList<>();
    String r = bigInteger.toString();
    for (int i = 0; i < r.length(); i++) {
      res.add(Integer.parseInt(String.valueOf(r.charAt(i))));
    }
    return res;
  }
}
