package puzzles;

import com.pholser.junit.quickcheck.ForAll;
import org.junit.Test;
import org.junit.contrib.theories.Theories;
import org.junit.contrib.theories.Theory;
import org.junit.runner.RunWith;

import static puzzles.SquareRoot.squareRoot;

@RunWith(Theories.class)
public class SquareRootTest {

    @Theory
    public void checkSquareRoot(@ForAll double x) {
        if (x < 0) return;
        assert checkAns(x);
    }

    @Test
    public void testSquareRoot() throws Exception {
        assert checkAns(4);
        assert checkAns(2);
        assert checkAns(1);
        assert checkAns(0);
        assert checkAns(0.0004);
    }

    private boolean checkAns(double x) {
        double sqrtx = squareRoot(x);
        return Math.abs(sqrtx * sqrtx - x) <= x * SquareRoot.EPS;
    }
}