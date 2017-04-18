/** https://leetcode.com/problems/jump-game/ Created by pankaj on 18/04/17. */
public class JumpGame {
  public boolean canJump(int[] nums) {
    if (nums == null) return true;
    int N = nums.length, best = 0;
    for (int i = 0; i <= best && best < N; i++) {
      best = Math.max(best, i + nums[i]);
    }
    return best >= N - 1;
  }
}
