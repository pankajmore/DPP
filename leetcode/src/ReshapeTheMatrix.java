/** https://leetcode.com/problems/reshape-the-matrix/ Created by pankaj on 30/04/17. */
class ReshapeTheMatrix {
  int[][] matrixReshape(final int[][] nums, final int r, final int c) {
    if (nums == null || nums.length == 0 || nums[0].length == 0) {
      return nums;
    }
    final int m = nums.length, n = nums[0].length;
    if (m * n != r * c) {
      return nums;
    }
    final int[][] reshape = new int[r][c];
    for (int i = 0, cnt = 0; i < m; i++) {
      for (int j = 0; j < n; j++, cnt++) {
        reshape[cnt / c][cnt % c] = nums[i][j];
      }
    }
    return reshape;
  }
}
