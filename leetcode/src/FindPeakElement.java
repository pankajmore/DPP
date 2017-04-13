/** https://leetcode.com/problems/find-peak-element/ Created by pankaj on 13/04/17. */
public class FindPeakElement {
  public int findPeakElement(int[] nums) {
    int N = nums.length;
    for (int i = 0; i < N; i++) {
      long curr = nums[i];
      long prev = i == 0 ? Long.MIN_VALUE : nums[i - 1];
      long next = i == N - 1 ? Long.MIN_VALUE : nums[i + 1];
      if (curr > prev && curr > next) return i;
    }
    return -1;
  }
}
