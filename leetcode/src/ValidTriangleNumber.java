import java.util.Arrays;

/** https://leetcode.com/problems/valid-triangle-number/ Created by pankaj on 12/06/17. */
class ValidTriangleNumber {
  int triangleNumber(final int[] nums) {
    Arrays.sort(nums);
    int cnt = 0;
    for (int i = 0; i < nums.length; i++) {
      for (int j = i + 1; j < nums.length; j++) {
        cnt += lessThanIdx(nums, j, nums[i] + nums[j]) - j;
      }
    }
    return cnt;
  }

  private int lessThanIdx(final int[] nums, final int start, final int x) {
    int lo = start, hi = nums.length - 1, idx = lo;
    while (lo <= hi) {
      int mid = (lo + hi) >>> 1;
      if (nums[mid] >= x) {
        hi = mid - 1;
      } else {
        idx = mid;
        lo = mid + 1;
      }
    }
    return idx;
  }
}
