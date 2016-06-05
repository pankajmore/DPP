package puzzles;

import com.pholser.junit.quickcheck.ForAll;
import com.pholser.junit.quickcheck.generator.InRange;
import org.junit.Assert;
import org.junit.contrib.theories.Theories;
import org.junit.contrib.theories.Theory;
import org.junit.runner.RunWith;

/**
 * Created by pankaj on 6/5/16.
 */
@RunWith(Theories.class)
public class PowerXYTest {
    @Theory
    public void compare(@ForAll @InRange(minDouble = 1, maxDouble = 10) double a,
                        @ForAll @InRange(minInt = 0, maxInt = 8) int n) {
        double expected = Math.pow(a, n);
        Assert.assertEquals(expected, PowerXY.recPow(a, n), 1E-5);
        Assert.assertEquals(expected, PowerXY.iterPow(a, n), 1E-5);
    }
}