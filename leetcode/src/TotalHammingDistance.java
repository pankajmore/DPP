/**
 * https://leetcode.com/contest/leetcode-weekly-contest-13/problems/total-hamming-distance/ Created
 * by pankaj on 18/12/16.
 */
public class TotalHammingDistance {
  public int totalHammingDistance(int[] nums) {
    int N = nums.length, cnt = 0;
    for (int i = 0; i < 32; i++) {
      int ones = 0;
      for (int j = 0; j < N; j++) {
        ones += nums[j] & 1;
        nums[j] >>>= 1;
      }
      cnt += ones * (N - ones);
    }
    return cnt;
  }
}
