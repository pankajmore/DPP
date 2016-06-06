package puzzles;

import com.pholser.junit.quickcheck.ForAll;
import com.pholser.junit.quickcheck.generator.InRange;
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
    public void compare(@ForAll @InRange(minDouble = 1, maxDouble = 10) double a,
                        @ForAll @InRange(minInt = -8, maxInt = 8) int n) {
        final double expected = Math.pow(a, n);
        Assert.assertEquals(expected, recPow(a, n), 1E-5);
        Assert.assertEquals(expected, iterPow(a, n), 1E-5);
    }

    @Theory
    public void compareMod(@ForAll @InRange(minLong = 1L, maxLong = 10L) long a,
                           @ForAll @InRange(minLong = 0L, maxLong = 10L) long n,
                           @ForAll @InRange(minLong = 1L) long m) {
        final long expected = Long.parseLong(new BigInteger(String.valueOf(a)).modPow(new BigInteger(String.valueOf(n)), new BigInteger(String.valueOf(m))).toString());
        Assert.assertEquals(expected, iterPow(a, n, m));
        Assert.assertEquals(expected, recPow(a, n, m));
    }
}