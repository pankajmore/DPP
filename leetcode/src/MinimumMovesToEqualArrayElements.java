/**
 * https://leetcode.com/contest/12/problems/minimum-moves-to-equal-array-elements/ Created by pankaj
 * on 11/6/16.
 */
class MinimumMovesToEqualArrayElements {
  int minMoves(int[] nums) {
    int N = nums.length;
    if (N == 0) return 0;
    int min = Integer.MAX_VALUE;
    for (int n : nums) min = Math.min(min, n);
    int sum = 0;
    for (int n : nums) sum += n - min;
    return sum;
  }
}
