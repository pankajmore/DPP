package puzzles;

import java.util.List;

/**
 * Created by Pankaj on 8/9/15.
 */
public class ScoreCombination {
    /**
     * DP optimised solution
     * Time complexity : O(s*n^2) where n = W.size()
     * Space Complexity : O(s)
     *
     * @param s the score s
     * @param W the list of points
     * @return number of ways s can be scored using points in W
     */
    public static int countCombinationsDP(int s, List<Integer> W) {
        int[] A = new int[s + 1];
        A[0] = 1;
        for (int i = 1; i <= s; i++) A[i] = i % W.get(0) == 0 ? 1 : 0;
        for (int i = 1; i < W.size(); i++) {
            for (int j = s; j >= 0; j--) {
                int k = j - W.get(i);
                while (k >= 0) {
                    A[j] += A[k];
                    k -= W.get(i);
                }
            }
        }
        return A[s];
    }

    /**
     * Recursive exponential algorithm
     *
     * @param s the score s
     * @param W the list of points
     * @return number of ways s can be scored using points in W
     */
    public static int countCombinationsRecursive(int s, List<Integer> W) {
        if (s == 0) return 1;
        if (W.size() == 1) return s % W.get(0) == 0 ? 1 : 0;
        int x = W.get(W.size() - 1), c = 0;
        List<Integer> tail = W.subList(0, W.size() - 1);
        while (s >= 0) {
            c += countCombinationsRecursive(s, tail);
            s -= x;
        }
        return c;
    }
}
