package dp;

import com.sun.istack.internal.NotNull;

/**
 * http://jeffe.cs.illinois.edu/teaching/algorithms/notes/05-dynprog.pdf
 * Page - 23, Q13
 * Created by pankaj on 19/11/16.
 */
public class Q13 {
    public static int lcsNonOverlapFB(@NotNull String s) {
        int N = s.length();
        int[][] dp = new int[N][N];
        int max = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; i + j < N - 1; j++) {
                dp[i][j] = s.charAt(i) != s.charAt(N - 1 - j) ? 0 : (i == 0 || j == 0 ? 0 : dp[i - 1][j - 1]) + 1;
                max = Math.max(max, dp[i][j]);
            }
        }
        return max;
    }

    public static int lcsNonOverlapFBSlow(@NotNull String s) {
        int N = s.length();
        int max = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i; j < N; j++) {
                String sub = s.substring(i, j + 1);
                String r = new StringBuilder(sub).reverse().toString();
                String rem = s.substring(j + 1);
                if (rem.contains(r)) max = Math.max(max, j - i + 1);
            }
        }
        return max;
    }
}
