package dailycodingproblem;

/**
 * Implement integer exponentiation. That is, implement the pow(x, y) function, where x and y are
 * integers and returns x^y.
 *
 * <p>Do this faster than the naive method of repeated multiplication.
 */
class DCP61 {
  static int pow(int x, int n) {
    int res = 1;
    while (n > 0) {
      if ((n & 1) == 1) {
        res *= x;
      }
      n >>>= 1;
      x *= x;
    }
    return res;
  }
}
