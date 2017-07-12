import java.util.Arrays;

/** http://www.lintcode.com/en/problem/paint-house-ii/ Created by pankaj on 12/07/17. */
class PaintHouseII {
  /**
   * @param costs n x k cost matrix
   * @return an integer, the minimum cost to paint all houses
   */
  int minCostII(final int[][] costs) {
    if (costs == null || costs.length == 0 || costs[0].length == 0) {
      return 0;
    }
    int n = costs.length;
    int k = costs[0].length;
    int[] dp = new int[k];
    for (int i = 0; i < k; i++) {
      dp[i] = costs[0][i];
    }
    for (int i = 1; i < n; i++) {
      int[] next = minExcludingSelf(dp);
      for (int j = 0; j < k; j++) {
        next[j] += costs[i][j];
      }
      dp = next;
    }
    int min = Integer.MAX_VALUE;
    for (int cost : dp) {
      min = Math.min(min, cost);
    }
    return min;
  }

  private int[] minExcludingSelf(final int[] costs) {
    int n = costs.length;
    int[] min = new int[n];
    Arrays.fill(min, Integer.MAX_VALUE);
    int left = Integer.MAX_VALUE;
    for (int i = 1; i < n; i++) {
      min[i] = Math.min(left, costs[i - 1]);
      left = Math.min(left, costs[i - 1]);
    }
    int right = Integer.MAX_VALUE;
    for (int i = n - 2; i >= 0; i--) {
      min[i] = Math.min(right, Math.min(min[i], costs[i + 1]));
      right = Math.min(right, costs[i + 1]);
    }
    return min;
  }
}
