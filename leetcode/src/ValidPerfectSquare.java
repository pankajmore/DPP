/** https://leetcode.com/problems/valid-perfect-square/ Created by pankaj on 26/01/17. */
public class ValidPerfectSquare {
  public boolean isPerfectSquare(int num) {
    int lo = 1, hi = num;
    while (lo <= hi) {
      int mid = lo + (hi - lo) / 2;
      long p = (long) mid * (long) mid;
      if (p == num) return true;
      else if (p > num) hi = mid - 1;
      else lo = mid + 1;
    }
    return false;
  }

  public boolean isPerfectSquare1(int num) {
    long r = num;
    while (r * r > num) {
      r = (r + num / r) / 2;
    }
    return r * r == num;
  }
}
