/** https://leetcode.com/problems/integer-break/ Created by pankaj on 26/04/17. */
public class IntegerBreak {
  public int integerBreak(int n) {
    int[] dp = new int[n + 1];
    dp[1] = 1;
    for (int i = 2; i <= n; i++) {
      for (int j = 1; 2 * j <= i; j++) {
        dp[i] = Math.max(dp[i], Math.max(j, dp[j]) * Math.max(i - j, dp[i - j]));
      }
    }
    return dp[n];
  }
}
