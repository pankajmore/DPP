package dailycodingproblem;

/**
 * Given a list of integers, write a function that returns the largest sum of non-adjacent numbers.
 * For example, [2, 4, 6, 8] should return 12, since we pick 4 and 8. [5, 1, 1, 5] should return 10,
 * since we pick 5 and 5.
 */
class DCP09 {
  static int largestSumNonAdjacent(int[] in) {
    if (in == null || in.length == 0) {
      return 0;
    }
    int a = 0;
    int b = in[0];
    for (int i = 1; i < in.length; i++) {
      int tmp = Math.max(in[i] + a, b);
      a = b;
      b = tmp;
    }
    return b;
  }
}
