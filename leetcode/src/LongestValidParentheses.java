/** https://leetcode.com/problems/longest-valid-parentheses/ Created by pankaj on 12/07/17. */
class LongestValidParentheses {
  int longestValidParentheses(final String s) {
    int len = s.length(), best = 0;
    int[] dp = new int[len];
    for (int i = 1; i < len; i++) {
      char c = s.charAt(i);
      if (c == ')') {
        int x = i - dp[i - 1] - 1;
        if (x >= 0 && s.charAt(x) == '(') {
          if (x >= 1) {
            dp[i] = dp[i - 1] + 2 + dp[x - 1];
          } else {
            dp[i] = dp[i - 1] + 2;
          }
        }
      }
      best = Math.max(best, dp[i]);
    }
    return best;
  }
}
