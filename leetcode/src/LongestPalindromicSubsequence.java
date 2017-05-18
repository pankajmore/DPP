/** https://leetcode.com/problems/longest-palindromic-subsequence/ Created by pankaj on 18/05/17. */
class LongestPalindromicSubsequence {
  int longestPalindromeSubseq(final String s) {
    if (s == null || s.isEmpty()) {
      return 0;
    }
    String r = new StringBuilder().append(s).reverse().toString();
    int n = s.length();
    int[][] dp = new int[n + 1][n + 1];
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= n; j++) {
        if (s.charAt(i - 1) == r.charAt(j - 1)) {
          dp[i][j] = dp[i - 1][j - 1] + 1;
        } else {
          dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
        }
      }
    }
    return dp[n][n];
  }
}
