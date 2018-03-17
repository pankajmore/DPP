package dailycodingproblem;

import java.util.Arrays;

/**
 * There is an N by M matrix of zeroes. Given N and M, write a function to count the number of ways
 * of starting at the top-left corner and getting to the bottom-right corner. You can only move
 * right or down.
 */
class DCP62 {
  static int numWays(int m, int n) {
    if (m == 0 || n == 0) {
      return 0;
    }
    int[] numWays = new int[n];
    Arrays.fill(numWays, 1);
    for (int i = 1; i < m; i++) {
      int left = 0;
      for (int j = 0; j < n; j++) {
        int top = numWays[j];
        numWays[j] = left + top;
        left = numWays[j];
      }
    }
    return numWays[n - 1];
  }
}
