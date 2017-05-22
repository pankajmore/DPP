import java.util.HashMap;
import java.util.Map;

/** https://leetcode.com/problems/longest-harmonious-subsequence/ Created by pankaj on 21/05/17. */
class LongestHarmoniousSubsequence {
  int findLHS(final int[] nums) {
    int max = 0;
    Map<Integer, Integer> cnt = new HashMap<>();
    for (int num : nums) {
      cnt.put(num, cnt.getOrDefault(num, 0) + 1);
      if (cnt.containsKey(num - 1)) {
        max = Math.max(max, cnt.get(num) + cnt.get(num - 1));
      }
      if (cnt.containsKey(num + 1)) {
        max = Math.max(max, cnt.get(num) + cnt.get(num + 1));
      }
    }
    return max;
  }
}
