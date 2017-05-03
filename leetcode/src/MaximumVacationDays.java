import java.util.Arrays;

/** https://leetcode.com/problems/maximum-vacation-days Created by pankaj on 03/05/17. */
class MaximumVacationDays {
  int maxVacationDays(final int[][] flights, final int[][] days) {
    int n = flights.length, k = days[0].length;
    int[] dp = new int[n];
    Arrays.fill(dp, Integer.MIN_VALUE);
    dp[0] = 0;
    for (int w = 0; w < k; w++) {
      int[] tmp = new int[n];
      for (int i = 0; i < n; i++) {
        tmp[i] = Integer.MIN_VALUE;
        for (int j = 0; j < n; j++) {
          if (i == j || flights[j][i] == 1) {
            tmp[i] = Math.max(tmp[i], dp[j] + days[i][w]);
          }
        }
      }
      dp = tmp;
    }
    int max = 0;
    for (int x : dp) {
      max = Math.max(max, x);
    }
    return max;
  }
}
