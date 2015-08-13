package puzzles;

import java.util.List;

/**
 * Created by Pankaj on 8/9/15.
 */
public class ScoreCombination {
    /**
     * DP optimised solution
     * Time complexity : O(s*n) where n = scores.size()
     * Space Complexity : O(s)
     *
     * @param s the score s
     * @param scores the list of scores
     * @return number of ways s can be scored using scores in W
     */
    public static int countCombinationsDP(int s, List<Integer> scores) {
        int[] A = new int[s + 1];
        A[0] = 1;
        for (Integer score : scores) {
            for (int j = score; j <= s; j++) A[j] += A[j - score];
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
