package puzzles;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Pankaj on 9/8/15.
 */
public class ThreeSum {
    /**
     * Give an array of n numbers, find if there exist 3 (possibly repeated)
     * numbers that sum to k
     * Time : O(n^2)
     * Space : O(n)
     *
     * @param A array of n numbers
     * @param k the sum
     * @return
     */
    public static boolean slow(Integer[] A, int k) {
        Set<Integer> set = new HashSet<>(Arrays.asList(A));
        for (int x : A)
            for (int y : A) if (set.contains(k - x - y)) return true;
        return false;
    }

    /* There is an O(nlogn) solution if numbers are non-negative and max(A) ~ O(n)
    * Using FFT*/
}
