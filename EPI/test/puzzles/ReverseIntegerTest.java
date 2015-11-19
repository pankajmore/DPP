package puzzles;

import com.pholser.junit.quickcheck.ForAll;
import org.junit.contrib.theories.Theories;
import org.junit.contrib.theories.Theory;
import org.junit.runner.RunWith;

@RunWith(Theories.class)
public class ReverseIntegerTest {
    @Theory
    public void testReverse(@ForAll int x) {
        if (Math.abs(x) > Integer.MAX_VALUE / 10) return; // at boundaries reverse might overflow
        assert ReverseInteger.reverse(x) == ReverseInteger.reverseUsingString(x);
        assert ReverseInteger.reverse(ReverseInteger.reverse(x)) == x;
    }
}