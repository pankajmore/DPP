import java.util.Arrays;
import java.util.Collections;

/**
 * https://leetcode.com/problems/longest-line-of-consecutive-one-in-matrix Created by pankaj on
 * 04/05/17.
 */
class LongestLineOfConsecutiveOneInMatrix {
  int longestLine(final int[][] A) {
    if (A.length == 0 || A[0].length == 0) {
      return 0;
    }
    int m = A.length;
    int n = A[0].length;
    int max = 0;
    int[][][] dp = new int[m][n][4];
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (A[i][j] == 1) {
          dp[i][j][0] = 1;
          dp[i][j][1] = 1;
          dp[i][j][2] = 1;
          dp[i][j][3] = 1;
          if (i > 0) {
            dp[i][j][0] += dp[i - 1][j][0];
          }
          if (j > 0) {
            dp[i][j][1] += dp[i][j - 1][1];
          }
          if (i > 0 && j > 0) {
            dp[i][j][2] += dp[i - 1][j - 1][2];
          }
          if (i > 0 && j + 1 < n) {
            dp[i][j][3] += dp[i - 1][j + 1][3];
          }
          max =
              Collections.max(
                  Arrays.asList(max, dp[i][j][0], dp[i][j][1], dp[i][j][2], dp[i][j][3]));
        }
      }
    }
    return max;
  }
}
