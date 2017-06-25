import java.util.Arrays;

/**
 * https://leetcode.com/problems/maximum-product-of-three-numbers/ Created by pankaj on 25/06/17.
 */
class MaximumProductOfThreeNumbers {
  int maximumProduct(final int[] nums) {
    Arrays.sort(nums);
    int len = nums.length;
    return Math.max(
        nums[len - 1] * nums[len - 2] * nums[len - 3], nums[0] * nums[1] * nums[len - 1]);
  }
}
