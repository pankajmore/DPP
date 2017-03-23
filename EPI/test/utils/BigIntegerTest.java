package utils;

import com.pholser.junit.quickcheck.ForAll;
import com.pholser.junit.quickcheck.generator.InRange;
import org.junit.Assert;
import org.junit.contrib.theories.Theories;
import org.junit.contrib.theories.Theory;
import org.junit.runner.RunWith;

@RunWith(Theories.class)
public class BigIntegerTest {

  @Theory
  public void compareAdd(@ForAll java.math.BigInteger x, @ForAll java.math.BigInteger y) {
    BigInteger a = new BigInteger(x.toString());
    BigInteger b = new BigInteger(y.toString());
    assert a.add(b).toString().equals(x.add(y).toString());
  }

  @Theory
  public void compareMultiply(@ForAll java.math.BigInteger x, @ForAll java.math.BigInteger y) {
    BigInteger a = new BigInteger(x.toString());
    BigInteger b = new BigInteger(y.toString());
    assert x.multiply(y).toString().equals(a.multiply(b).toString());
  }

  @Theory
  public void comparePow(
      @ForAll @InRange(minInt = 0 /* TODO: Fix for -ve */, maxInt = 10) int x,
      @ForAll @InRange(minInt = 0, maxInt = 100) int n) {
    java.math.BigInteger expected = new java.math.BigInteger(String.valueOf(x)).pow(n);
    BigInteger actual = new BigInteger(String.valueOf(x)).pow(n);
    Assert.assertEquals(expected.toString(), actual.toString());
  }
}
