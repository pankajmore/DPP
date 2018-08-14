/** https://leetcode.com/problems/climbing-stairs/ Created by pankaj on 9/26/16. */
class ClimbingStairs {
  int climbStairs(int n) {
    if (n < 2) return n;
    int a = 1, b = 2;
    for (int i = 3; i <= n; i++) {
      int tmp = b;
      b = a + b;
      a = tmp;
    }
    return b;
  }
}
