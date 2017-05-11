/** https://leetcode.com/problems/out-of-boundary-paths/ Created by pankaj on 11/05/17. */
class OutOfBoundaryPaths {
  private static final int MOD = 1000000007;

  int findPaths(final int m, final int n, final int numMoves, final int x, final int y) {
    int count = 0;
    int[][] curr = new int[m][n];
    curr[x][y] = 1;
    for (int move = 1; move <= numMoves; move++) {
      int[][] prev = curr;
      curr = new int[m][n];
      for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
          int c = 0;
          if (i == 0) {
            count = (count + prev[i][j]) % MOD;
          } else if (i > 0) {
            c = (c + prev[i - 1][j]) % MOD;
          }
          if (j == 0) {
            count = (count + prev[i][j]) % MOD;
          } else if (j > 0) {
            c = (c + prev[i][j - 1]) % MOD;
          }
          if (i == m - 1) {
            count = (count + prev[i][j]) % MOD;
          } else if (i < m - 1) {
            c = (c + prev[i + 1][j]) % MOD;
          }
          if (j == n - 1) {
            count = (count + prev[i][j]) % MOD;
          } else if (j < n - 1) {
            c = (c + prev[i][j + 1]) % MOD;
          }
          curr[i][j] = c;
        }
      }
    }
    return count;
  }
}
