package puzzles;

import com.pholser.junit.quickcheck.ForAll;
import org.junit.contrib.theories.Theories;
import org.junit.contrib.theories.Theory;
import org.junit.runner.RunWith;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

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

    @Theory
    public void carefullyChosenMustNotExist(@ForAll Integer[] A) {
        int k = notDefinitelyInA(A);
        assert !ThreeSum.slow(A, k);
    }

    private int notDefinitelyInA(Integer[] A) {
        Set<Integer> set = new HashSet<>(Arrays.asList(A));
        while (true) {
            int x = new Random().nextInt();
            x = 3 * Math.abs(x);
            if (set.contains(x / 3)) continue;
            for (int d = 0; d <= x; d++) if (twoSumCheck(A, x - d)) continue;
            return x;
        }
    }

    private boolean twoSumCheck(Integer[] A, Integer k) {
        Set<Integer> set = new HashSet<>(Arrays.asList(A));
        for (Integer x : A) {
            if (set.contains(k - x)) return true;
        }
        return false;
    }
}