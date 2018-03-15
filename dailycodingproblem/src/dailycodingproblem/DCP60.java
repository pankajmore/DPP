package dailycodingproblem;

import java.util.Arrays;

/**
 * Given a set of integers, return whether the set can be partitioned into two subsets whose sums
 * are the same.
 */
class DCP60 {
  static boolean canPartition(int[] in) {
    if (in == null || in.length == 0) {
      return true;
    }
    int len = in.length;
    int total = 0;
    for (int x : in) {
      total += x;
    }
    if ((total & 1) == 1) {
      return false;
    }
    Arrays.sort(in);
    // subsetSum[i][j] = does there exist a subset in in[0..i] whose sum = j - total
    boolean subsetSum[][] = new boolean[len + 1][2 * total + 1];
    subsetSum[0][total] = true;
    for (int i = 1; i <= len; i++) {
      for (int j = 0; j <= 2 * total; j++) {
        int prevSum = j - in[i - 1];
        subsetSum[i][j] = subsetSum[i - 1][j];
        if (prevSum >= 0 && prevSum <= 2 * total) {
          subsetSum[i][j] |= subsetSum[i - 1][prevSum];
        }
      }
    }
    return subsetSum[len][total + total / 2];
  }
}
