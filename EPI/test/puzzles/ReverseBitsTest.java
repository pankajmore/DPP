package puzzles;

import com.pholser.junit.quickcheck.ForAll;
import org.junit.contrib.theories.Theories;
import org.junit.contrib.theories.Theory;
import org.junit.runner.RunWith;

@RunWith(Theories.class)
public class ReverseBitsTest {
    @Theory
    public void bothImplementationShouldMatch(@ForAll long x) {
        assert ReverseBits.reverse(x) == ReverseBits.reverseA(x);
    }

    @Theory
    public void reverseOfReverseIsId(@ForAll long x) {
        assert ReverseBits.reverseA(ReverseBits.reverseA(x)) == x;
        assert ReverseBits.reverse(ReverseBits.reverse(x)) == x;
    }
}