/**
 * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/ Created by pankaj on
 * 19/07/17.
 */
class FindMinimumInRotatedSortedArrayII {
  int findMin(final int[] nums) {
    int lo = 0;
    int hi = nums.length - 1;
    while (lo < hi) {
      int mid = (lo + hi) >>> 1;
      if (nums[mid] < nums[hi]) {
        hi = mid;
      } else if (nums[mid] > nums[hi]) {
        lo = mid + 1;
      } else {
        hi--;
      }
    }
    return nums[lo];
  }
}
