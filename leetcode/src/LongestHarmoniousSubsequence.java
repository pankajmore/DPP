import java.util.Arrays;

/** https://leetcode.com/problems/longest-harmonious-subsequence/ Created by pankaj on 21/05/17. */
class LongestHarmoniousSubsequence {
  int findLHS(final int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }
    Arrays.sort(nums);
    int curr = nums[0];
    int currCnt = 1;
    Integer prev = null;
    int prevCnt = 0;
    int max = 0;
    for (int i = 1; i < nums.length; i++) {
      if (nums[i] == nums[i - 1]) {
        currCnt++;
      } else {
        if (prev != null && curr == prev + 1) {
          max = Math.max(max, prevCnt + currCnt);
        }
        prev = curr;
        prevCnt = currCnt;
        curr = nums[i];
        currCnt = 1;
      }
    }
    if (prev != null && curr == prev + 1) {
      max = Math.max(max, prevCnt + currCnt);
    }
    return max;
  }
}
