package puzzles;

import java.util.*;

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

    public static List<Integer> closest(Integer[] A, int k) {
        Arrays.sort(A);
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (Integer x : A) {
            for (Integer y : A) {
                int t = Arrays.binarySearch(A, k - x - y);
                if (t >= 0 && t < A.length) return Arrays.asList(x, y, k - x - y);
                else if (t == A.length) map.put(k - x - y - A[A.length - 1], Arrays.asList(x, y, k - x - y));
                else {
                    if (A[-t + 1] - k > k - A[-t]) map.put(A[-t + 1] - k, Arrays.asList(x, y, A[-t + 1]));
                    else map.put(k - A[-t], Arrays.asList(x, y, A[-t]));
                }
            }
        }
        int minKey = Collections.min(map.keySet());
        return map.get(minKey);
    }
}
