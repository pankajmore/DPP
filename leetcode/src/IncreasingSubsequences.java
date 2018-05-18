import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/** https://leetcode.com/problems/increasing-subsequences/ Created by pankaj on 22/01/17. */
public class IncreasingSubsequences {
  public List<List<Integer>> findSubsequences(int[] nums) {
    int N = nums.length;
    Set<List<Integer>> ls = new HashSet<>();
    for (int i = 0; i < (1 << N); i++) {
      int d = i;
      List<Integer> l = new ArrayList<>();
      for (int j = 0; j < N; j++) {
        if ((d & 1) == 1) {
          if (!l.isEmpty() && l.get(l.size() - 1) > nums[j]) break;
          l.add(nums[j]);
        }
        d >>>= 1;
      }
      if (l.size() > 1) ls.add(l);
    }
    return new ArrayList<>(ls);
  }

  public List<List<Integer>> findSubsequences1(int[] nums) {
    List<Integer> l = new ArrayList<>();
    Set<List<Integer>> set = new HashSet<>();
    findSubsequencesHelper(nums, 0, l, set);
    return new ArrayList<>(set);
  }

  private void findSubsequencesHelper(
      int[] nums, int idx, List<Integer> l, Set<List<Integer>> set) {
    if (idx == nums.length) {
      if (l.size() > 1) set.add(new ArrayList<>(l));
    } else {
      if (l.isEmpty() || l.get(l.size() - 1) <= nums[idx]) {
        l.add(nums[idx]);
        findSubsequencesHelper(nums, idx + 1, l, set);
        l.remove(l.size() - 1);
      }
      findSubsequencesHelper(nums, idx + 1, l, set);
    }
  }
}
