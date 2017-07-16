/** https://leetcode.com/problems/maximum-average-subarray-i/ Created by pankaj on 16/07/17. */
class MaximumAverageSubarrayI {
  public double findMaxAverage(final int[] nums, final int k) {
    double max = Double.NEGATIVE_INFINITY;
    double sum = 0;
    for (int i = 0; i < k; i++) {
      sum += (double) nums[i] / k;
    }
    max = Math.max(max, sum);
    for (int i = k; i < nums.length; i++) {
      sum = sum - (double) nums[i - k] / k + (double) nums[i] / k;
      max = Math.max(max, sum);
    }
    return max;
  }
}
