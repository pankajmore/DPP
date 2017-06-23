import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/** https://leetcode.com/problems/subsets-ii/ Created by pankaj on 23/06/17. */
class SubsetsII {
  List<List<Integer>> subsetsWithDup(final int[] nums) {
    Arrays.sort(nums);
    List<List<Integer>> subsets = new ArrayList<>();
    subsetsInternal(subsets, new ArrayList<>(), nums, 0);
    return subsets;
  }

  private void subsetsInternal(
      final List<List<Integer>> subsets,
      final List<Integer> subset,
      final int[] nums,
      final int start) {
    subsets.add(new ArrayList<>(subset));
    for (int i = start; i < nums.length; i++) {
      if (i == start || (i > start && nums[i] != nums[i - 1])) {
        subset.add(nums[i]);
        subsetsInternal(subsets, subset, nums, i + 1);
        subset.remove(subset.size() - 1);
      }
    }
  }
}
