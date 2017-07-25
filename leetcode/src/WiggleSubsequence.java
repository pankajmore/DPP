import java.util.Arrays;

/** https://leetcode.com/problems/wiggle-subsequence/ Created by pankaj on 25/07/17. */
class WiggleSubsequence {
  int wiggleMaxLength(final int[] nums) {
    if (nums.length < 2) {
      return nums.length;
    }
    int n = nums.length;
    int[] inc = new int[n];
    int[] dec = new int[n];
    Arrays.fill(inc, 1);
    Arrays.fill(dec, 1);
    for (int i = 1; i < n; i++) {
      for (int j = 0; j < i; j++) {
        if (nums[j] < nums[i]) {
          inc[i] = Math.max(inc[i], dec[j] + 1);
        } else if (nums[j] > nums[i]) {
          dec[i] = Math.max(dec[i], inc[j] + 1);
        }
      }
    }
    return Math.max(inc[n - 1], dec[n - 1]);
  }
}
