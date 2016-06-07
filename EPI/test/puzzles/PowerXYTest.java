package puzzles;

import com.pholser.junit.quickcheck.ForAll;
import org.junit.Assert;
import org.junit.contrib.theories.Theories;
import org.junit.contrib.theories.Theory;
import org.junit.runner.RunWith;

import java.math.BigInteger;

import static puzzles.PowerXY.iterPow;
import static puzzles.PowerXY.recPow;

/**
 * Created by pankaj on 6/5/16.
 */
@RunWith(Theories.class)
public class PowerXYTest {
    @Theory
    public void compare(@ForAll double a, @ForAll int n) {
        final double expected = Math.pow(a, n);
        Assert.assertEquals(expected, recPow(a, n), Math.abs(expected) / 1E5);
        Assert.assertEquals(expected, iterPow(a, n), Math.abs(expected / 1E5));
    }

    @Theory
    public void compareMod(@ForAll long a,
                           @ForAll long n,
                           @ForAll long m) {
        try {
            final long expected = Long.parseLong(new BigInteger(String.valueOf(a))
                    .modPow(new BigInteger(String.valueOf(n)), new BigInteger(String.valueOf(m))).toString());
            Assert.assertEquals(expected, iterPow(a, n, m));
            Assert.assertEquals(expected, recPow(a, n, m));
        } catch (ArithmeticException | IllegalArgumentException e) {
        }
    }
}