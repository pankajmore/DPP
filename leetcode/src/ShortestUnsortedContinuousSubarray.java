import java.util.Arrays;

/**
 * https://leetcode.com/problems/shortest-unsorted-continuous-subarray/ Created by pankaj on
 * 16/05/17.
 */
class ShortestUnsortedContinuousSubarray {
  int findUnsortedSubarray(final int[] nums) {
    int start = 0, n = nums.length;
    while (start + 1 < n) {
      if (nums[start] > nums[start + 1]) {
        break;
      }
      start++;
    }
    if (start == n - 1) {
      return 0;
    }
    int max = nums[start], min = nums[start];
    int end = start + 1;
    for (int i = start + 1; i < n; i++) {
      if (nums[i] < max) {
        end = i;
      }
      max = Math.max(max, nums[i]);
      min = Math.min(min, nums[i]);
    }
    for (int i = start - 1; i >= 0; i--) {
      if (nums[i] > min) {
        start = i;
      }
    }
    return end - start + 1;
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
