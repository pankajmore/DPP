package puzzles;

/** Created by pankaj on 2/26/16. */
public class RodCutting {
  public static int maxRodCut(int[] prices) {
    int N = prices.length;
    int[] dp = new int[N + 1];
    dp[0] = 0;
    for (int i = 1; i <= N; i++) {
      dp[i] = prices[i - 1];
      for (int j = 0; j < i; j++) {
        dp[i] = Math.max(dp[i], dp[j] + prices[i - j - 1]);
      }
    }
    return dp[N];
  }
}
