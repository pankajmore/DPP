/**
 * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/ Created by pankaj on
 * 24/03/17.
 */
class FindMinimumInRotatedSortedArray {
  int findMin(int[] nums) {
    int lo = 0, hi = nums.length - 1;
    while (lo < hi) {
      int mid = lo + (hi - lo) / 2;
      if (nums[mid] > nums[hi]) lo = mid + 1;
      else hi = mid;
    }
    return nums[lo];
  }
}
