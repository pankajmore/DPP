/**
 * Created by pankaj on 3/2/16.
 */
public class LongestRepeatingSubsequence {
    /**
     * Time : O(N^2)
     * Space: O(N)
     *
     * @param s string of size N
     * @return the length of the longest repeating subsequence
     */
    public static int longestRepeatingSubsequence(String s) {
        int N = s.length();
        int[][] dp = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (i != j && s.charAt(i - 1) == s.charAt(j - 1))
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[N][N];
    }
}
