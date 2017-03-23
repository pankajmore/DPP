package puzzles;

import java.util.List;

/** Created by pankaj on 2/3/16. */
public class PickingUpCoins {
  public static int maxRevenue(List<Integer> coins) {
    int N = coins.size();
    int[][] dp = new int[N][N];
    return maxRevenueHelper(coins, 0, N - 1, dp);
  }

  public static int maxRevenue1(List<Integer> coins) {
    int N = coins.size();
    int[][][] dp = new int[2][N][N];
    return maxRevenueHelper1(coins, 0, N - 1, dp, 0);
  }

  private static int maxRevenueHelper1(
      List<Integer> coins, int i, int j, int[][][] dp, int player) {
    if (i > j) return 0;
    if (dp[player][i][j] == 0) {
      if (player == 0)
        dp[player][i][j] =
            Math.max(
                coins.get(i) + maxRevenueHelper1(coins, i + 1, j, dp, 1),
                coins.get(j) + maxRevenueHelper1(coins, i, j - 1, dp, 1));
      else
        dp[player][i][j] =
            Math.min(
                maxRevenueHelper1(coins, i + 1, j, dp, 0),
                maxRevenueHelper1(coins, i, j - 1, dp, 0));
    }
    return dp[player][i][j];
  }

  private static int maxRevenueHelper(List<Integer> coins, int i, int j, int[][] dp) {
    if (i > j) return 0;
    if (dp[i][j] == 0) {
      dp[i][j] =
          Math.max(
              coins.get(i)
                  + Math.min(
                      maxRevenueHelper(coins, i + 1, j - 1, dp),
                      maxRevenueHelper(coins, i + 2, j, dp)),
              coins.get(j)
                  + Math.min(
                      maxRevenueHelper(coins, i, j - 2, dp),
                      maxRevenueHelper(coins, i + 1, j - 1, dp)));
    }
    return dp[i][j];
  }
}
