import java.util.Arrays;

/** https://leetcode.com/problems/maximum-length-of-pair-chain/ Created by pankaj on 24/07/17. */
class MaximumLengthOfPairChain {
  int findLongestChain(final int[][] pairs) {
    Arrays.sort(
        pairs,
        (x, y) -> {
          if (x[1] == y[1]) {
            return x[0] - y[0];
          } else {
            return x[1] - y[1];
          }
        });
    int cnt = 0;
    int last = Integer.MIN_VALUE;
    for (int[] p : pairs) {
      if (last == Integer.MIN_VALUE || p[0] > last) {
        last = p[1];
        cnt++;
      }
    }
    return cnt;
  }
}
