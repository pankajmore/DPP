/** https://leetcode.com/problems/set-mismatch/ Created by pankaj on 24/07/17. */
class SetMismatch {
  int[] findErrorNums(final int[] nums) {
    int n = nums.length;
    int x = 0;
    for (int num : nums) {
      x ^= num;
    }
    for (int i = 1; i <= n; i++) {
      x ^= i;
    }
    int mask = x & ~(x - 1);
    int a = 0;
    int b = 0;
    for (int num : nums) {
      if ((num & mask) == 0) {
        a ^= num;
      } else {
        b ^= num;
      }
    }
    for (int i = 1; i <= n; i++) {
      if ((i & mask) == 0) {
        a ^= i;
      } else {
        b ^= i;
      }
    }
    for (int num : nums) {
      if (num == a) {
        return new int[] {a, b};
      } else if (num == b) {
        return new int[] {b, a};
      }
    }
    return new int[] {};
  }
}
