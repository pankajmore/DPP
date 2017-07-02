/** https://leetcode.com/problems/sum-of-square-numbers/ Created by pankaj on 02/07/17. */
class SumOfSquareNumbers {
  boolean judgeSquareSum(final int c) {
    for (long a = 0; a * a <= c; a++) {
      double b = Math.sqrt(c - a * a);
      if (b == (int) b) {
        return true;
      }
    }
    return false;
  }
}
