import com.sun.istack.internal.NotNull;

import java.util.List;

/**
 * Created by pankaj on 11/4/16.
 */
public class CardGame {
    public static long maxScore(@NotNull List<Integer> A) {
        return maxScoreHelper(A, 0, A.size() - 1, 0, true);
    }

    private static long maxScoreHelper(List<Integer> A, int i, int j, long score, boolean move) {
        if (i > j) return score;
        return move ? Math.max(maxScoreHelper(A, i + 1, j, score + A.get(i), false),
                maxScoreHelper(A, i, j - 1, score + A.get(j), false))
                : Math.min(maxScoreHelper(A, i + 1, j, score, true), maxScoreHelper(A, i, j - 1, score, true));
    }

    /**
     * Time : O(N^2)
     * Space: O(N^2)
     */
    public static long maxScoreDP(@NotNull List<Integer> A) {
        int N = A.size();
        if (N == 0) return 0;
        long[][] dp = new long[N][N];
        for (int d = 0; d < N; d++) {
            for (int i = 0, j = d; j < N; i++, j++) {
                long u = i + 2 > j ? 0 : dp[i + 2][j];
                long v = i + 1 > j - 1 ? 0 : dp[i + 1][j - 1];
                long w = i > j - 2 ? 0 : dp[i][j - 2];
                dp[i][j] = Math.max(A.get(i) + Math.min(u, v), A.get(j) + Math.min(v, w));
            }
        }
        return dp[0][N - 1];
    }

    /**
     * Time: O(N^2)
     * Space: O(N^2)
     */
    public static long maxScoreAgainstGreedy(@NotNull List<Integer> A) {
        int N = A.size();
        if (N == 0) return 0;
        long[][] dp = new long[N][N];
        for (int d = 0; d < N; d++) {
            for (int i = 0, j = d; j < N; i++, j++) {
                long u = i + 1 > j ? 0 : A.get(i + 1) > A.get(j) ? (i + 2 > j ? 0 : dp[i + 2][j]) :
                        i + 1 > j - 1 ? 0 : dp[i + 1][j - 1];
                long v = i > j - 1 ? 0 : A.get(i) < A.get(j - 1) ? (i > j - 2 ? 0 : dp[i][j - 2]) :
                        i + 1 > j - 1 ? 0 : dp[i + 1][j - 1];
                dp[i][j] = Math.max(A.get(i) + u, A.get(j) + v);
            }
        }
        return dp[0][N - 1];
    }
}
