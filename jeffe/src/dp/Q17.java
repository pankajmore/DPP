package dp;

import com.sun.istack.internal.NotNull;

import java.util.List;

/**
 * http://jeffe.cs.illinois.edu/teaching/algorithms/notes/05-dynprog.pdf
 * Page - 24, Q17
 * Created by pankaj on 25/11/16.
 */
public class Q17 {
    /**
     * Time : O(M^2 * N^2)
     * Space: O(M * N)
     */
    public static int maxScoreA(@NotNull List<List<Integer>> A) {
        if (A.size() == 0 || A.get(0).size() == 0) return Integer.MIN_VALUE;
        int M = A.size(), N = A.get(0).size();
        int[][] dp = new int[M][N];
        int max = Integer.MIN_VALUE;
        for (int x = 0; x < M; x++) {
            for (int y = 0; y < N; y++) {
                for (int i = x; i < M; i++) {
                    for (int j = y; j < N; j++) {
                        dp[i][j] = Math.max(i == x ? 0 : dp[i - 1][j], j == y ? 0 : dp[i][j - 1])
                                + A.get(i).get(j);
                    }
                }
                for (int i = x; i < M; i++) max = Math.max(max, dp[i][N - 1]);
                for (int j = y; j < N; j++) max = Math.max(max, dp[M - 1][j]);
            }
        }
        return max;
    }
}
