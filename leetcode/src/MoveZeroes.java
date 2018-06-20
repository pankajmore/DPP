/** https://leetcode.com/problems/move-zeroes/ Created by pankaj on 10/26/16. */
public class MoveZeroes {
  public void moveZeroes(int[] nums) {
    int i, idx, N = nums.length;
    for (i = 0, idx = 0; i < N; i++) {
      if (nums[i] != 0) {
        int tmp = nums[idx];
        nums[idx++] = nums[i];
        nums[i] = tmp;
      }
    }
  }
}
