/** https://leetcode.com/problems/unique-paths/ Created by pankaj on 15/06/17. */
class UniquePaths {
  int uniquePaths(final int m, final int n) {
    int[][] paths = new int[m][n];
    paths[0][0] = 1;
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (i > 0) {
          paths[i][j] += paths[i - 1][j];
        }
        if (j > 0) {
          paths[i][j] += paths[i][j - 1];
        }
      }
    }
    return paths[m - 1][n - 1];
  }
}
