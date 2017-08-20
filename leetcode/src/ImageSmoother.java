/** https://leetcode.com/problems/image-smoother/ Created by pankaj on 20/08/17. */
class ImageSmoother {
  private static final int[] DIRS = {-1, 0, 1};

  int[][] imageSmoother(final int[][] in) {
    if (in == null || in.length == 0 || in[0].length == 0) {
      return in;
    }
    int r = in.length;
    int c = in[0].length;
    int[][] out = new int[r][c];
    for (int i = 0; i < r; i++) {
      for (int j = 0; j < c; j++) {
        out[i][j] = average(in, i, j);
      }
    }
    return out;
  }

  private int average(final int[][] in, final int i, final int j) {
    int s = 0;
    int n = 0;
    for (int ii : DIRS) {
      for (int jj : DIRS) {
        if (check(in, i - ii, j - jj)) {
          s += in[i - ii][j - jj];
          n++;
        }
      }
    }
    return s / n;
  }

  private boolean check(final int[][] in, final int i, final int j) {
    return i >= 0 && i < in.length && j >= 0 && j < in[i].length;
  }
}
