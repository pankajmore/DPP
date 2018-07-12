/** https://leetcode.com/problems/maximum-product-subarray/ Created by pankaj on 9/15/16. */
public class MaximumProductSubarray {
  public int maxProduct(int[] nums) {
    if (nums == null || nums.length == 0) return 1;
    int N = nums.length;
    int max = nums[0], maxSoFar = nums[0], minSoFar = nums[0];
    for (int i = 1; i < N; i++) {
      int x = nums[i];
      int temp = Math.max(x, Math.max(maxSoFar * x, minSoFar * x));
      minSoFar = Math.min(x, Math.min(maxSoFar * x, minSoFar * x));
      maxSoFar = temp;
      max = Math.max(max, maxSoFar);
    }
    return max;
  }
}
