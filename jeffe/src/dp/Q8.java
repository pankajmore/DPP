package dp;

import com.sun.istack.internal.NotNull;

import java.util.Arrays;

/**
 * http://jeffe.cs.illinois.edu/teaching/algorithms/notes/05-dynprog.pdf
 * Page - 21, Q8
 * Created by pankaj on 11/11/16.
 */
public class Q8 {
    /**
     * Time: O(N^2)
     * Space: O(N^2)
     */
    public static int longestPalindromicSubsequence(@NotNull String s) {
        int N = s.length();
        if (N == 0) return 0;
        int[][] dp = new int[N][N];
        for (int d = 0; d < N; d++) {
            for (int i = 0, j = d; j < N; i++, j++) {
                dp[i][j] = Math.max(dp[i][j], i == j ? 1 :
                        s.charAt(i) == s.charAt(j) ? (i + 1 > j - 1 ? 0 : dp[i + 1][j - 1]) + 2 :
                                Math.max(dp[i + 1][j], dp[i][j - 1]));
            }
        }
        return dp[0][N - 1];
    }

    /**
     * Time: O(N^2)
     * Space: O(N)
     */
    public static int longestPalindromicSubsequence1(@NotNull String s) {
        int N = s.length();
        if (N == 0) return 0;
        String r = new StringBuilder(s).reverse().toString();
        int[] lcs = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            int prev = lcs[0];
            for (int j = 1; j <= N; j++) {
                int tmp = lcs[j];
                lcs[j] = s.charAt(i - 1) == r.charAt(j - 1) ? prev + 1 :
                        Math.max(lcs[j], lcs[j - 1]);
                prev = tmp;
            }
        }
        return lcs[N];
    }

    /**
     * Time: O(N^3)
     * Space: O(N^2)
     */
    public static int longestPalindromicSubsequenceSlow(@NotNull String s) {
        int N = s.length();
        if (N == 0) return 0;
        int[][] dp = new int[N][N];
        for (int d = 0; d < N; d++) {
            for (int i = 0, j = d; j < N; i++, j++) {
                dp[i][j] = 1;
                for (int k = i; k <= j; k++) {
                    int l = find(s, k, j);
                    dp[i][j] = Math.max(dp[i][j], k + 1 > l - 1 ? (k == l ? 1 : 2) : dp[k + 1][l - 1] + 2);
                }
            }
        }
        return dp[0][N - 1];
    }

    /**
     * Time: O(N^2)
     * Space: O(N^2)
     */
    public static int shortestPalindromicSupersequence(@NotNull String s) {
        return 2 * s.length() - longestPalindromicSubsequence(s);
    }

    /**
     * Time: O(N^2)
     * Space: O(N^2)
     */
    public static int minimumPalindromicDecomposition(@NotNull String s) {
        int N = s.length();
        if (N == 0) return 0;
        boolean[][] isPalindrome = palindromicSubstrings(s);
        int[] dp = new int[N];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 1;
        for (int i = 1; i < N; i++) {
            for (int j = 0; j <= i; j++) {
                dp[i] = Math.min(dp[i], isPalindrome[j][i] ? (j - 1 < 0 ? 0 : dp[j - 1]) + 1 : Integer.MAX_VALUE);
            }
        }
        return dp[N - 1];
    }

    private static boolean[][] palindromicSubstrings(@NotNull String s) {
        int N = s.length();
        boolean[][] dp = new boolean[N][N];
        for (int m = 0; m < N; m++) {
            for (int i = m, j = m; i >= 0 && j < N && s.charAt(i) == s.charAt(j); i--, j++) {
                dp[i][j] = true;
            }
            for (int i = m, j = m + 1; i >= 0 && j < N && s.charAt(i) == s.charAt(j); i--, j++) {
                dp[i][j] = true;
            }
        }
        return dp;
    }

    private static int find(String s, int begin, int end) {
        char c = s.charAt(begin);
        for (int i = end; i > begin; i--) {
            if (s.charAt(i) == c) return i;
        }
        return begin;
    }
}
