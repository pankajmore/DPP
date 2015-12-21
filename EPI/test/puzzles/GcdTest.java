package puzzles;

import com.pholser.junit.quickcheck.ForAll;
import org.junit.contrib.theories.Theories;
import org.junit.contrib.theories.Theory;
import org.junit.runner.RunWith;

import static puzzles.Gcd.*;

@RunWith(Theories.class)
public class GcdTest {

    @Theory
    public void testGcd(@ForAll int a, @ForAll int b) throws Exception {
        if (a <= 0 || b <= 0) return;
        assert gcd(a, b) == gcdSimple(a, b);
        assert gcdRecursive(a, b) == gcdSimple(a, b);
    }
}