/** http://www.lintcode.com/en/problem/paint-house/ Created by pankaj on 11/07/17. */
class PaintHouse {
  private static final int NUM_COLORS = 3;

  /**
   * @param costs n x 3 cost matrix
   * @return an integer, the minimum cost to paint all houses
   */
  int minCost(final int[][] costs) {
    if (costs == null || costs.length == 0) {
      return 0;
    }
    int n = costs.length;
    int[] dp = new int[NUM_COLORS];
    dp[0] = costs[0][0];
    dp[1] = costs[0][1];
    dp[2] = costs[0][2];
    for (int i = 1; i < n; i++) {
      int[] next = new int[NUM_COLORS];
      next[0] = costs[i][0] + Math.min(dp[1], dp[2]);
      next[1] = costs[i][1] + Math.min(dp[0], dp[2]);
      next[2] = costs[i][2] + Math.min(dp[0], dp[1]);
      dp = next;
    }
    return Math.min(dp[0], Math.min(dp[1], dp[2]));
  }
}
