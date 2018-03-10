package dailycodingproblem;

import java.util.ArrayList;
import java.util.List;

/**
 * The power set of a set is the set of all its subsets. Write a function that, given a set,
 * generates its power set.
 */
class DCP37 {
  List<List<Integer>> subsets(int[] nums) {
    if (nums == null) return null;
    int len = nums.length;
    if (len > 31) throw new IllegalArgumentException("Input too big!");
    List<List<Integer>> subsets = new ArrayList<>();
    for (int i = 0; i < 1 << len; i++) {
      subsets.add(subset(nums, i));
    }
    return subsets;
  }

  List<Integer> subset(int[] nums, int mask) {
    List<Integer> subset = new ArrayList<>();
    for (int i = 0; i < nums.length && mask > 0; i++) {
      if ((mask & 1) == 1) {
        subset.add(nums[i]);
      }
      mask >>= 1;
    }
    return subset;
  }
}
