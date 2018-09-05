/**
 * https://leetcode.com/problems/longest-increasing-path-in-a-matrix/ Created by pankaj on 31/03/17.
 */
class LongestIncreasingPathInAMatrix {
  private static final int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

  int longestIncreasingPath(int[][] matrix) {
    if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
    int max = 1, M = matrix.length, N = matrix[0].length;
    int[][] dp = new int[M][N];
    for (int i = 0; i < M; i++) {
      for (int j = 0; j < N; j++) {
        max = Math.max(max, longestIncreasingPathHelper(i, j, matrix, dp));
      }
    }
    return max;
  }

  private int longestIncreasingPathHelper(int i, int j, int[][] matrix, int[][] dp) {
    int max = 1;
    if (dp[i][j] > 0) return dp[i][j];
    for (int[] d : dirs) {
      int u = i + d[0], v = j + d[1];
      if (isValid(u, v, matrix) && matrix[u][v] > matrix[i][j]) {
        max = Math.max(max, 1 + longestIncreasingPathHelper(u, v, matrix, dp));
      }
    }
    return dp[i][j] = max;
  }

  private boolean isValid(int i, int j, int[][] matrix) {
    return i >= 0 && i < matrix.length && j >= 0 && j < matrix[0].length;
  }
}
