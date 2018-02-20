/** https://leetcode.com/problems/max-area-of-island/description/ */
class MaxAreaOfIsland {
  int maxAreaOfIsland(int[][] grid) {
    if (grid == null || grid.length == 0 || grid[0].length == 0) {
      return 0;
    }
    int m = grid.length;
    int n = grid[0].length;
    int maxArea = 0;
    boolean[][] visited = new boolean[m][n];
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (grid[i][j] == 1 && !visited[i][j]) {
          maxArea = Math.max(maxArea, visit(grid, visited, i, j));
        }
      }
    }
    return maxArea;
  }

  private int visit(int[][] grid, boolean[][] visited, int i, int j) {
    if (i < 0
        || i >= grid.length
        || j < 0
        || j >= grid[i].length
        || grid[i][j] == 0
        || visited[i][j]) {
      return 0;
    }
    visited[i][j] = true;
    return 1
        + visit(grid, visited, i + 1, j)
        + visit(grid, visited, i, j + 1)
        + visit(grid, visited, i - 1, j)
        + visit(grid, visited, i, j - 1);
  }
}
