/** https://leetcode.com/problems/find-peak-element/ Created by pankaj on 13/04/17. */
public class FindPeakElement {
  public int findPeakElement(int[] nums) {
    int N = nums.length, lo = 0, hi = N - 1;
    while (lo <= hi) {
      int mid = lo + (hi - lo) / 2;
      long curr = nums[mid];
      long prev = mid == 0 ? Long.MIN_VALUE : nums[mid - 1];
      long next = mid == N - 1 ? Long.MIN_VALUE : nums[mid + 1];
      long max = Math.max(curr, Math.max(prev, next));
      if (max == prev) hi = mid - 1;
      else if (max == next) lo = mid + 1;
      else return mid;
    }
    return -1;
  }
}
