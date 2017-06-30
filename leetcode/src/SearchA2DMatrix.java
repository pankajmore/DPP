/** https://leetcode.com/problems/search-a-2d-matrix/ Created by pankaj on 30/06/17. */
class SearchA2DMatrix {
  boolean searchMatrix(final int[][] matrix, final int target) {
    if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
      return false;
    }
    int rows = matrix.length;
    int cols = matrix[0].length;
    int lo = 0, hi = rows * cols - 1;
    while (lo <= hi) {
      int mid = (lo + hi) >>> 1;
      int x = mid / cols;
      int y = mid % cols;
      if (matrix[x][y] < target) {
        lo = mid + 1;
      } else if (matrix[x][y] > target) {
        hi = mid - 1;
      } else {
        return true;
      }
    }
    return false;
  }
}
