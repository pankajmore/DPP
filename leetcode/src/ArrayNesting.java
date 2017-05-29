import java.util.HashSet;

/** https://leetcode.com/problems/array-nesting/ Created by pankaj on 29/05/17. */
class ArrayNesting {
  int arrayNesting(final int[] nums) {
    int max = 0;
    HashSet<Integer> visited = new HashSet<>();
    for (int num : nums) {
      int curr = num, cnt = 0;
      while (!visited.contains(curr)) {
        visited.add(curr);
        curr = nums[curr];
        cnt++;
      }
      max = Math.max(max, cnt);
    }
    return max;
  }
}
