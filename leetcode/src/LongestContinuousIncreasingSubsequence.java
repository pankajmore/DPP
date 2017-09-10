/**
 * https://leetcode.com/problems/longest-continuous-increasing-subsequence/ Created by pankaj on
 * 10/09/17.
 */
class LongestContinuousIncreasingSubsequence {
  int findLengthOfLCIS(final int[] nums) {
    if (nums.length == 0) {
      return 0;
    }
    int max = 1;
    int curr = 1;
    for (int i = 1; i < nums.length; i++) {
      if (nums[i] > nums[i - 1]) {
        curr++;
      } else {
        curr = 1;
      }
      max = Math.max(max, curr);
    }
    return max;
  }
}
