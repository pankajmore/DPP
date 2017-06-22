import java.util.ArrayList;
import java.util.List;

/** https://leetcode.com/problems/subsets/ Created by pankaj on 21/06/17. */
class Subsets {
  List<List<Integer>> subsets(final int[] nums) {
    if (nums.length > Integer.SIZE) {
      throw new IllegalArgumentException("too large to find subsets of size : " + nums.length);
    }
    List<List<Integer>> subsets = new ArrayList<>(1 << nums.length);
    for (int i = 0; i < 1 << nums.length; i++) {
      List<Integer> subset = new ArrayList<>();
      for (int j = 0; j < nums.length; j++) {
        if (((i >> j) & 1) == 1) {
          subset.add(nums[j]);
        }
      }
      subsets.add(subset);
    }
    return subsets;
  }

  List<List<Integer>> subsets1(final int[] nums) {
    List<List<Integer>> subsets = new ArrayList<>();
    backtrack(subsets, new ArrayList<>(), nums, 0);
    return subsets;
  }

  private void backtrack(
      final List<List<Integer>> subsets,
      final List<Integer> subset,
      final int[] nums,
      final int start) {
    subsets.add(new ArrayList<>(subset));
    for (int i = start; i < nums.length; i++) {
      subset.add(nums[i]);
      backtrack(subsets, subset, nums, i + 1);
      subset.remove(subset.size() - 1);
    }
  }
}
