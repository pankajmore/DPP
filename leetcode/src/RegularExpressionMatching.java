/**
 * https://leetcode.com/problems/regular-expression-matching/
 * Created by pankaj on 3/8/16.
 */
public class RegularExpressionMatching {
    /**
     * Time : O(NM)
     * Space: O(M)
     *
     * @param s string of length N
     * @param p pattern of length M
     * @return if p matches s
     */
    public boolean isMatch(String s, String p) {
        int N = s.length(), M = p.length();
        boolean[] dp = new boolean[M + 1];
        dp[0] = true;
        for (int i = 2; i <= M; i += 2)
            if (p.charAt(i - 1) == '*') dp[i] = true;
            else break;
        for (int i = 1; i <= N; i++) {
            dp[0] = false;
            boolean prev = i == 1, temp;
            for (int j = 1; j <= M; j++) {
                temp = dp[j];
                char c = p.charAt(j - 1);
                if (c == '.') dp[j] = prev;
                else if (c != '*') dp[j] = prev && c == s.charAt(i - 1);
                else dp[j] = dp[j - 2] || (dp[j] && (p.charAt(j - 2) == '.' || p.charAt(j - 2) == s.charAt(i - 1)));
                prev = temp;
            }
        }
        return dp[M];
    }
}
