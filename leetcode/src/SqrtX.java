/** https://leetcode.com/problems/sqrtx/ Created by pankaj on 9/2/16. */
public class SqrtX {
  public static int mySqrt(int x) {
    if (x < 0) return -1;
    long lo = 0, hi = x, ans = hi;
    while (lo <= hi) {
      long mid = lo + (hi - lo) / 2;
      if (mid * mid > x) hi = mid - 1;
      else {
        ans = mid;
        lo = mid + 1;
      }
    }
    return (int) ans;
  }

  public static int mySqrt1(int x) {
    long r = x;
    while (r * r > x) r = (r + x / r) / 2;
    return (int) r;
  }
}
