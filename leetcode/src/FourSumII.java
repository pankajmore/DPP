import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/contest/smarking-algorithm-contest-4/problems/4sum-ii/ Created by pankaj on
 * 14/11/16.
 */
class FourSumII {
  int fourSumCount(final int[] l1, final int[] l2, final int[] l3, final int[] l4) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int x : l1) {
      for (int y : l2) {
        map.put(x + y, map.getOrDefault(x + y, 0) + 1);
      }
    }
    int cnt = 0;
    for (int x : l3) {
      for (int y : l4) {
        cnt += map.getOrDefault(-x - y, 0);
      }
    }
    return cnt;
  }
}
