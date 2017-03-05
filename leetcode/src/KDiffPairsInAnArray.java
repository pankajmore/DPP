import java.util.HashMap;
import java.util.Map;

/** https://leetcode.com/problems/k-diff-pairs-in-an-array/ Created by pankaj on 05/03/17. */
public class KDiffPairsInAnArray {
  public int findPairs(int[] nums, int k) {
    if (k < 0) return 0;
    Map<Integer, Integer> map = new HashMap<>();
    for (int x : nums) {
      map.put(x, map.getOrDefault(x, 0) + 1);
    }
    int ans = 0;
    if (k == 0) {
      for (int x : map.keySet()) {
        ans += map.get(x) > 1 ? 1 : 0;
      }
    } else {
      for (int x : map.keySet()) {
        ans += map.containsKey(x + k) ? 1 : 0;
      }
    }
    return ans;
  }
}
