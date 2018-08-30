/** https://leetcode.com/problems/dungeon-game/ Created by pankaj on 31/03/17. */
class DungeonGame {
  int calculateMinimumHP(int[][] A) {
    if (A.length == 0 || A[0].length == 0) return 0;
    int M = A.length, N = A[0].length;
    int[][] dp = new int[M][N];
    for (int i = M - 1; i >= 0; i--) {
      for (int j = N - 1; j >= 0; j--) {
        dp[i][j] = Integer.MAX_VALUE;
        if (i + 1 < M) {
          dp[i][j] = Math.min(dp[i][j], dp[i + 1][j] - A[i][j]);
        }
        if (j + 1 < N) {
          dp[i][j] = Math.min(dp[i][j], dp[i][j + 1] - A[i][j]);
        }
        if (dp[i][j] <= 0) dp[i][j] = 1;
        if (dp[i][j] == Integer.MAX_VALUE) dp[i][j] = Math.max(1, 1 - A[i][j]);
      }
    }
    return dp[0][0];
  }
}
