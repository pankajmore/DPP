/** https://leetcode.com/problems/arithmetic-slices/ Created by pankaj on 20/02/17. */
class ArithmeticSlices {
  int numberOfArithmeticSlices(final int[] nums) {
    int len = nums.length;
    int cnt = 0, x = 0;
    for (int i = 2; i < len; i++) {
      if (nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) {
          x++;
      } else {
          x = 0;
      }
      cnt += x;
    }
    return cnt;
  }
}
