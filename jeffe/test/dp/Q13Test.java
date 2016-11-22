package dp;

import com.pholser.junit.quickcheck.ForAll;
import com.pholser.junit.quickcheck.generator.InRange;
import org.junit.Assert;
import org.junit.Test;
import org.junit.contrib.theories.Theories;
import org.junit.contrib.theories.Theory;
import org.junit.runner.RunWith;

import java.util.List;

/**
 * Created by pankaj on 19/11/16.
 */
@RunWith(Theories.class)
public class Q13Test {
    @Test
    public void lcsNonOverlapFB() throws Exception {
        Assert.assertEquals(0, Q13.lcsNonOverlapFB(""));
        Assert.assertEquals(0, Q13.lcsNonOverlapFB("a"));
        Assert.assertEquals(0, Q13.lcsNonOverlapFB("ab"));
        Assert.assertEquals(1, Q13.lcsNonOverlapFB("aa"));
        Assert.assertEquals(1, Q13.lcsNonOverlapFB("aba"));
        Assert.assertEquals(2, Q13.lcsNonOverlapFB("abba"));

        Assert.assertEquals(0, Q13.lcsNonOverlapFB("ALGORITHM"));
        Assert.assertEquals(1, Q13.lcsNonOverlapFB("RECURSION"));
        Assert.assertEquals(3, Q13.lcsNonOverlapFB("REDIVIDE"));
        Assert.assertEquals(4, Q13.lcsNonOverlapFB("DYNAMICPROGRAMMINGMANYTIMES"));
    }

    @Theory
    public void compare(@ForAll @InRange(minInt = 0, maxInt = 1) List<Integer> A) {
        StringBuilder sb = new StringBuilder();
        A.forEach(sb::append);
        String s = sb.toString();
        int expected = Q13.lcsNonOverlapFBSlow(s);
        int actual = Q13.lcsNonOverlapFB(s);
        Assert.assertEquals(expected, actual);
    }
}