package leetcode;

/**
 * https://leetcode.com/problems/regular-expression-matching/
 * Created by pankaj on 3/8/16.
 */
public class RegularExpressionMatching {
    /**
     * Time : O(NM)
     * Space: O(NM)
     *
     * @param s string of length N
     * @param p pattern of length M
     * @return if p matches s
     */
    public boolean isMatch(String s, String p) {
        int N = s.length(), M = p.length();
        boolean[][] dp = new boolean[N + 1][M + 1];
        dp[0][0] = true;
        for (int i = 2; i <= M; i += 2)
            if (p.charAt(i - 1) == '*') dp[0][i] = true;
            else break;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                char c = p.charAt(j - 1);
                if (c == '.') dp[i][j] = dp[i - 1][j - 1];
                else if (c != '*') dp[i][j] = dp[i - 1][j - 1] && c == s.charAt(i - 1);
                else
                    dp[i][j] = dp[i][j - 2] || (dp[i - 1][j] && (p.charAt(j - 2) == '.' || p.charAt(j - 2) == s.charAt(i - 1)));
            }
        }
        return dp[N][M];
    }
}
