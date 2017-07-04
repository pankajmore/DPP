/** https://leetcode.com/problems/rotate-image/ Created by pankaj on 04/07/17. */
class RotateImage {
  void rotate(final int[][] matrix) {
    int n = matrix.length;
    for (int i = 0; i < n / 2; i++) {
      for (int j = i; j < n - i - 1; j++) {
        int tmp = matrix[i][j];
        matrix[i][j] = matrix[n - j - 1][i];
        matrix[n - j - 1][i] = matrix[n - i - 1][n - j - 1];
        matrix[n - i - 1][n - j - 1] = matrix[j][n - i - 1];
        matrix[j][n - i - 1] = tmp;
      }
    }
  }

  void rotate1(final int[][] matrix) {
    int n = matrix.length;
    // reverse across horizontal axis
    for (int i = 0; i < n / 2; i++) {
      int[] tmp = matrix[i];
      matrix[i] = matrix[n - i - 1];
      matrix[n - i - 1] = tmp;
    }
    // transpose
    for (int i = 0; i < n; i++) {
      for (int j = i; j < n; j++) {
        int tmp = matrix[i][j];
        matrix[i][j] = matrix[j][i];
        matrix[j][i] = tmp;
      }
    }
  }
}
