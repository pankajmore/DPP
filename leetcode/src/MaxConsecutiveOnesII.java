/**
 * https://leetcode.com/contest/leetcode-weekly-contest-15/problems/max-consecutive-ones-ii/ Created
 * by pankaj on 15/01/17.
 */
class MaxConsecutiveOnesII {
  int findMaxConsecutiveOnes(int[] nums) {
    int max = 0, N = nums.length;
    int[] begin = new int[N], end = new int[N];
    for (int i = 0, j = N - 1; i < N; i++, j--) {
      end[i] = nums[i] == 0 ? 0 : (i == 0 ? 0 : end[i - 1]) + 1;
      begin[j] = nums[j] == 0 ? 0 : (j == N - 1 ? 0 : begin[j + 1]) + 1;
    }
    for (int i = 0; i < N; i++) {
      max = Math.max(max, (i == 0 ? 0 : end[i - 1]) + (i == N - 1 ? 0 : begin[i + 1]) + 1);
    }
    return max;
  }
}
