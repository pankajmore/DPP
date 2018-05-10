/** https://leetcode.com/problems/find-the-duplicate-number/ Created by pankaj on 10/11/16. */
public class FindTheDuplicateNumber {
  /** Time: O(NlogN) Space: O(1) */
  public int findDuplicate(int[] nums) {
    int lo = 1, hi = nums.length - 1;
    while (lo < hi) {
      int mid = lo + (hi - lo) / 2;
      int cnt = 0;
      for (int num : nums) {
        if (num <= mid) cnt++;
      }
      if (cnt > mid) {
        hi = mid;
      } else {
        lo = mid + 1;
      }
    }
    assert lo == hi;
    return lo;
  }
}
