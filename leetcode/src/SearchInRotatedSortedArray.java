/** https://leetcode.com/problems/search-in-rotated-sorted-array Created by pankaj on 24/03/17. */
public class SearchInRotatedSortedArray {
  public int search(int[] nums, int target) {
    if (nums == null || nums.length == 0) return -1;
    int N = nums.length;
    int idx = minIndex(nums);
    int r = binarySearch(nums, 0, Math.max(0, idx - 1), target);
    return r != -1 ? r : binarySearch(nums, idx, N - 1, target);
  }

  private int minIndex(int[] nums) {
    int lo = 0, hi = nums.length - 1;
    while (lo < hi) {
      int mid = lo + (hi - lo) / 2;
      if (nums[mid] > nums[hi]) {
        lo = mid + 1;
      } else {
        hi = mid;
      }
    }
    return lo;
  }

  private int binarySearch(int[] nums, int lo, int hi, int target) {
    while (lo <= hi) {
      int mid = lo + (hi - lo) / 2;
      if (nums[mid] == target) return mid;
      else if (nums[mid] < target) lo = mid + 1;
      else hi = mid - 1;
    }
    return -1;
  }
}