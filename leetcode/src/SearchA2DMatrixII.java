/** https://leetcode.com/problems/search-a-2d-matrix-ii/ Created by pankaj on 30/06/17. */
class SearchA2DMatrixII {
  boolean searchMatrix(final int[][] matrix, final int target) {
    if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
      return false;
    }
    int m = matrix.length;
    int n = matrix[0].length; // assume square
    int i = 0;
    int j = n - 1;
    while (i < m && j >= 0) {
      if (matrix[i][j] < target) {
        i++;
      } else if (matrix[i][j] > target) {
        j--;
      } else {
        return true;
      }
    }
    return false;
  }
}
