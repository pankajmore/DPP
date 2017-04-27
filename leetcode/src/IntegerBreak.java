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

  public int integerBreak1(int n) {
    if(n == 1) return 1;
    else if(n == 2) return 1;
    else if(n == 3) return 2;
    else {
      int p = 1;
      while(n > 4) {
        p *= 3;
        n -= 3;
      }
      p *= n;
      return p;
    }
  }
}
