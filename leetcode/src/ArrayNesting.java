/** https://leetcode.com/problems/array-nesting/ Created by pankaj on 29/05/17. */
class ArrayNesting {
  int arrayNesting(final int[] nums) {
    int max = 0;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] != Integer.MAX_VALUE) {
        int curr = nums[i], cnt = 0;
        while (nums[curr] != Integer.MAX_VALUE) {
          int tmp = curr;
          curr = nums[curr];
          cnt++;
          nums[tmp] = Integer.MAX_VALUE;
        }
        max = Math.max(max, cnt);
      }
    }
    return max;
  }
}
