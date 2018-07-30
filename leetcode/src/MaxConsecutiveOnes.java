/** https://leetcode.com/problems/max-consecutive-ones/ Created by pankaj on 15/01/17. */
public class MaxConsecutiveOnes {
  public int findMaxConsecutiveOnes(int[] nums) {
    int max = 0, curr = 0;
    for (int n : nums) {
      max = Math.max(max, curr = n == 0 ? 0 : curr + 1);
    }
    return max;
  }
}
