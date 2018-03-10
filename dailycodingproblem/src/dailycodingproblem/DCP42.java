package dailycodingproblem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Given a list of integers S and a target number k, write a function that returns a subset of S
 * that adds up to k. If such a subset cannot be made, then return null.
 *
 * <p>Integers can appear more than once in the list. You may assume all numbers in the list are
 * positive.
 */
class DCP42 {
  static List<Integer> subsetSum(List<Integer> list, int k) {
    int len = list.size();
    boolean[][] subsetSum = new boolean[len + 1][k + 1];
    subsetSum[0][0] = true;
    for (int i = 1; i <= len; i++) {
      subsetSum[i][0] = true;
      for (int j = 1; j <= k; j++) {
        subsetSum[i][j] = subsetSum[i - 1][j];
        if (list.get(i - 1) <= j) {
          subsetSum[i][j] |= subsetSum[i - 1][j - list.get(i - 1)];
        }
      }
    }
    if (subsetSum[len][k]) {
      List<Integer> subset = new ArrayList<>();
      for (int i = len, j = k; i > 0 && j > 0; ) {
        if (subsetSum[i - 1][j]) {
          i--;
        } else {
          assert subsetSum[i - 1][j - list.get(i - 1)];
          subset.add(list.get(i - 1));
          j -= list.get(i - 1);
          i--;
        }
      }
      Collections.reverse(subset);
      return subset;
    } else {
      return null;
    }
  }
}
