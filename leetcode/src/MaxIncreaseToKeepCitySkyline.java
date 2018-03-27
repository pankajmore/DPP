/** https://leetcode.com/problems/max-increase-to-keep-city-skyline/description/ */
class MaxIncreaseToKeepCitySkyline {
  int maxIncreaseKeepingSkyline(int[][] grid) {
    if (grid == null || grid.length == 0 || grid[0].length == 0) {
      return 0;
    }
    int m = grid.length;
    int n = grid[0].length;
    int[] skRow = new int[m];
    int[] skCol = new int[n];
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        skRow[i] = Math.max(skRow[i], grid[i][j]);
        skCol[j] = Math.max(skCol[j], grid[i][j]);
      }
    }
    int sum = 0;
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        sum += Math.min(skRow[i], skCol[j]) - grid[i][j];
      }
    }
    return sum;
  }
}
