package puzzles;

/** Created by pankaj on 3/31/16. */
public class Divide {
  /**
   * Time : O(Integer.SIZE) Space: O(Integer.SIZE)
   *
   * <p>
   *
   * @param dividend
   * @param divisor
   * @return quotient , if overflow -> return MIN_INT
   */
  public static int divide(int dividend, int divisor) {
    if (divisor == 0) throw new ArithmeticException("/ by zero");
    boolean sign = (dividend < 0) ^ (divisor < 0);
    if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MIN_VALUE;
    long dividendL = Math.abs((long) dividend);
    long divisorL = Math.abs((long) divisor);
    long n = 0, q = 0;
    for (int i = Integer.SIZE - 1; i >= 0; i--) {
      n <<= 1;
      q <<= 1;
      n |= (dividendL >> i) & 1;
      if (n >= divisorL) {
        q |= 1;
        n -= divisorL;
      }
    }
    return sign ? -(int) q : (int) q;
  }

  /**
   * Time : O(N * N) N is number of bits in the numbers Space: O(N)
   *
   * @param dividend
   * @param divisor
   * @return quotient, if overflow -> return MIN_INT
   */
  public static int divide1(int dividend, int divisor) {
    if (divisor == 0) throw new ArithmeticException("/ by zero");
    if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MIN_VALUE;
    boolean sign = (dividend < 0) ^ (divisor < 0);
    long dividendL = Math.abs((long) dividend);
    long divisorL = Math.abs((long) divisor);
    long q = 0, n = dividendL, power;
    while (n >= divisorL) {
      power = 1;
      while (divisorL << power <= n) power++;
      n -= divisorL << (power - 1);
      q += 1 << (power - 1);
    }
    return sign ? (int) -q : (int) q;
  }
}
