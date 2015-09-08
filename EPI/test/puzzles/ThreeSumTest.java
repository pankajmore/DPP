package puzzles;

import com.pholser.junit.quickcheck.ForAll;
import org.junit.contrib.theories.Theories;
import org.junit.contrib.theories.Theory;
import org.junit.runner.RunWith;

import java.util.Random;

@RunWith(Theories.class)
public class ThreeSumTest {
    @Theory
    public void randomlyChosenFromArrayMustExist(@ForAll Integer[] A) {
        int n = A.length;
        if (n == 0) return;
        int k = A[new Random().nextInt(n)] + A[new Random().nextInt(n)]
                + A[new Random().nextInt(n)];
        assert ThreeSum.slow(A, k);
    }
}