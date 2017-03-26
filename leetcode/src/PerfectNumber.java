/**
 * https://leetcode.com/contest/leetcode-weekly-contest-25/problems/perfect-number/ Created by
 * pankaj on 26/03/17.
 */
public class PerfectNumber {
  public boolean checkPerfectNumber(int num) {
    if (num < 2) return false;
    int s = 1;
    for (int i = 2; i <= Math.sqrt(num); i++) {
      if (num % i == 0) {
        s += i + num / i;
      }
      if (s > num) return false;
    }
    return s == num;
  }
}
