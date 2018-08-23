/**
 * https://leetcode.com/problems/count-numbers-with-unique-digits/ Created by pankaj on 18/08/17.
 */
class CountNumbersWithUniqueDigits {
  int countNumbersWithUniqueDigits(final int n) {
    if (n == 0) {
      return 1;
    }
    int c = 10, b = 9;
    for (int k = 2; k <= n; k++) {
      b = b * (9 - k + 2);
      c = c + b;
    }
    return c;
  }
}
