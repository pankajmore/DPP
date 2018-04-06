package dailycodingproblem;

/**
 * Given an array of integers, return a new array such that each element at index i of the new array
 * is the product of all the numbers in the original array except the one at i. Solve it without
 * using division and in O(n) time.
 *
 * <p>For example, if our input was [1, 2, 3, 4, 5], the expected output would be [120, 60, 40, 30,
 * 24]. If our input was [3, 2, 1], the expected output would be [2, 3, 6].
 */
class DCP02 {
  static int[] productExceptSelf(int[] in) {
    int[] out = new int[in.length];
    int left = 1;
    for (int i = 0; i < in.length; i++) {
      out[i] = left;
      left *= in[i];
    }
    int right = 1;
    for (int i = in.length - 1; i >= 0; i--) {
      out[i] *= right;
      right *= in[i];
    }
    return out;
  }
}
