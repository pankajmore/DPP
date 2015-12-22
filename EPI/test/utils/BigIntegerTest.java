package utils;

import com.pholser.junit.quickcheck.ForAll;
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
}