/** https://leetcode.com/problems/continuous-subarray-sum/ Created by pankaj on 13/05/17. */
class ContinuousSubarraySum {
  boolean checkSubarraySum(final int[] nums, final int k) {
    if (nums.length <= 1) {
      return false;
    }
    for (int i = 0; i < nums.length; i++) {
      int sum = nums[i];
      for (int j = i + 1; j < nums.length; j++) {
        sum += nums[j];
        if (k == 0) {
          if (sum == 0) {
            return true;
          }
        } else if (sum % k == 0) {
          return true;
        }
      }
    }
    return false;
  }
}
