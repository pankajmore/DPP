/** https://leetcode.com/problems/longest-palindromic-subsequence/ Created by pankaj on 18/05/17. */
class LongestPalindromicSubsequence {
  int longestPalindromeSubseq(final String s) {
    if (s == null || s.isEmpty()) {
      return 0;
    }
    int n = s.length();
    int[][] dp = new int[n][n];
    for (int i = n - 1; i >= 0; i--) {
      for (int j = i; j < n; j++) {
        if (i == j) {
          dp[i][i] = 1;
        } else if (s.charAt(i) == s.charAt(j)) {
          dp[i][j] = 2 + (i + 1 > j - 1 ? 0 : dp[i + 1][j - 1]);
        } else {
          dp[i][j] = Math.max(i + 1 >= n ? 0 : dp[i + 1][j], j - 1 < 0 ? 0 : dp[i][j - 1]);
        }
      }
    }
    return dp[0][n - 1];
  }
}
