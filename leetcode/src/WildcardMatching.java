/**
 * https://leetcode.com/problems/wildcard-matching/
 * Created by pankaj on 3/8/16.
 */
public class WildcardMatching {
    /**
     * Time : O(NM)
     * Space: O(M)
     *
     * @param s string of length N
     * @param p pattern of length M
     * @return if s is matched by p
     */
    public static boolean isMatch(String s, String p) {
        int N = s.length(), M = p.length();
        boolean[] dp = new boolean[M + 1];
        dp[0] = true;
        for (int j = 1; j <= M; j++) {
            if (p.charAt(j - 1) == '*') dp[j] = true;
            else break;
        }
        for (int i = 1; i <= N; i++) {
            boolean prev = i == 1, temp;
            dp[0] = false;
            for (int j = 1; j <= M; j++) {
                temp = dp[j];
                char c = p.charAt(j - 1);
                if (c == '?') dp[j] = prev;
                else if (c != '*') dp[j] = prev && c == s.charAt(i - 1);
                else dp[j] = dp[j] || dp[j - 1];
                prev = temp;
            }
        }
        return dp[M];
    }
}
