import java.util.Arrays;

/**
 * https://leetcode.com/problems/shortest-unsorted-continuous-subarray/ Created by pankaj on
 * 16/05/17.
 */
class ShortestUnsortedContinuousSubarray {
  int findUnsortedSubarray(final int[] nums) {
    int n = nums.length, beg = -1, end = -2, min = nums[n - 1], max = nums[0];
    for (int i = 1; i < n; i++) {
      max = Math.max(max, nums[i]);
      min = Math.min(min, nums[n - 1 - i]);
      if (nums[i] < max) {
        end = i;
      }
      if (nums[n - 1 - i] > min) {
        beg = n - 1 - i;
      }
    }
    return end - beg + 1;
  }

  int findUnsortedSubarray1(final int[] nums) {
    int[] sorted = nums.clone();
    Arrays.sort(sorted);
    int n = nums.length, start = n, end = 0;
    for (int i = 0; i < n; i++) {
      if (sorted[i] != nums[i]) {
        start = Math.min(start, i);
        end = Math.max(end, i);
      }
    }
    if (end < start) {
      return 0;
    } else {
      return end - start + 1;
    }
  }
}
