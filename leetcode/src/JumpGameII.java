/** https://leetcode.com/problems/jump-game-ii/ Created by pankaj on 19/04/17. */
public class JumpGameII {
  public int jump(int[] nums) {
    if (nums == null || nums.length == 0) return 0;
    int N = nums.length;
    int cnt = 0, curr = 0, next = nums[0];
    for (int i = 0; i < N && curr < N; i++) {
      if (i > curr) {
        curr = next;
        cnt++;
      }
      next = Math.max(next, i + nums[i]);
    }
    return curr >= N - 1 ? cnt : -1;
  }
}
