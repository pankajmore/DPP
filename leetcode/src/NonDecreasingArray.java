import java.util.Arrays;

/** https://leetcode.com/problems/non-decreasing-array/ Created by pankaj on 28/08/17. */
class NonDecreasingArray {
  boolean checkPossibility(final int[] nums) {
    int[] fst = Arrays.copyOf(nums, nums.length);
    int[] snd = Arrays.copyOf(nums, nums.length);

    for (int i = 1; i < nums.length; i++) {
      if (nums[i - 1] > nums[i]) {
        fst[i - 1] = fst[i];
        snd[i] = snd[i - 1];
        return valid(fst) || valid(snd);
      }
    }
    return true;
  }

  private boolean valid(final int[] nums) {
    for (int i = 1; i < nums.length; i++) {
      if (nums[i - 1] > nums[i]) {
        return false;
      }
    }
    return true;
  }
}
