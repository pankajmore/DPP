/**
 * https://leetcode.com/problems/single-element-in-a-sorted-array/ Created by pankaj on 06/06/17.
 */
class SingleElementInASortedArray {
  int singleNonDuplicate(final int[] nums) {
    int lo = 0, hi = nums.length - 1;
    while (lo < hi) {
      int mid = lo + (hi - lo) / 2;
      if (nums[mid] == nums[mid ^ 1]) {
        lo = mid + 1;
      } else {
        hi = mid;
      }
    }
    return nums[lo];
  }
}
