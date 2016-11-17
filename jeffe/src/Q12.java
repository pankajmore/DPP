import com.sun.istack.internal.NotNull;

/**
 * http://jeffe.cs.illinois.edu/teaching/algorithms/notes/05-dynprog.pdf
 * Page - 23, Q12
 * Created by pankaj on 17/11/16.
 */
public class Q12 {
    public static boolean isShuffle(@NotNull String X, @NotNull String Y, @NotNull String Z) {
        int M = X.length(), N = Y.length();
        if (M + N != Z.length()) return false;
        boolean[][] dp = new boolean[M + 1][N + 1];
        dp[0][0] = true;
        for (int i = 1; i <= M; i++) dp[i][0] = dp[i - 1][0] && X.charAt(i - 1) == Z.charAt(i - 1);
        for (int j = 1; j <= N; j++) dp[0][j] = dp[0][j - 1] && Y.charAt(j - 1) == Z.charAt(j - 1);
        for (int i = 1; i <= M; i++) {
            for (int j = 1; j <= N; j++) {
                dp[i][j] = dp[i - 1][j] && X.charAt(i - 1) == Z.charAt(i + j - 1) ||
                        dp[i][j - 1] && Y.charAt(j - 1) == Z.charAt(i + j - 1);
            }
        }
        return dp[M][N];
    }
}
