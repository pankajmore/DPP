/** https://leetcode.com/problems/largest-number-at-least-twice-of-others/description/ */
class LargestNumberAtLeastTwiceOfOthers {
  int dominantIndex(int[] nums) {
    if (nums == null || nums.length == 0) {
      return -1;
    }
    int max = nums[0];
    Integer secondMax = null;
    int maxIdx = 0;
    for (int i = 1; i < nums.length; i++) {
      if (nums[i] > max) {
        secondMax = max;
        max = nums[i];
        maxIdx = i;
      } else if (secondMax == null || nums[i] > secondMax) {
        secondMax = nums[i];
      }
    }
    if (secondMax != null && max < secondMax * 2) {
      return -1;
    } else {
      return maxIdx;
    }
  }
}
