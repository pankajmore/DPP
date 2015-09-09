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
    public void carefullyChosenKShouldReturnFalse(@ForAll(sampleSize = 1000) Integer[] A) {
        int k = -1;
        while (k == -1) k = findKThatCannotBeAchievedAsASumOf3Numbers(A);
        assert !ThreeSum.slow(A, k);
    }

    private int findKThatCannotBeAchievedAsASumOf3Numbers(Integer[] A) {
        Set<Integer> set = new HashSet<>(Arrays.asList(A));
        int k = new Random().nextInt();
        k = 3 * Math.abs(k);
        if (set.contains(k / 3)) return -1;
        for (Integer x : A) {
            if (set.contains(k - 2 * x)) return -1;
            if (twoSumCheck(A, k - x)) return -1;
        }
        return k;

    }

    private boolean twoSumCheck(Integer[] A, Integer k) {
        Set<Integer> set = new HashSet<>(Arrays.asList(A));
        for (Integer x : A) {
            if (set.contains(k - x)) return true;
        }
        return false;
    }
}