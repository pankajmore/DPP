package puzzles;

/** Created by Pankaj on 12/21/15. */
public class Gcd {
  /**
   * Gcd using only shit operations, comparison and subtraction
   *
   * @param a positive integer
   * @param b positive integer
   * @return gcd(a, b)
   */
  public static int gcd(int a, int b) {
    int k1 = 0, k2 = 0;
    while ((a & 1) == 0) {
      ++k1;
      a >>= 1;
    }
    while ((b & 1) == 0) {
      ++k2;
      b >>= 1;
    }
    while (a > 0 && b > 0) {
      assert (a & 1) == 1 && (b & 1) == 1;
      if (a < b) {
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
      }
      assert a >= b;
      a = a - b;
      while (a != 0 && (a & 1) == 0) a >>= 1;
    }
    return b << Math.min(k1, k2);
  }

  public static int gcdRecursive(int x, int y) {
    if (x == 0) return y;
    if (y == 0) return x;
    if ((x & 1) == 0 && (y & 1) == 0) return gcdRecursive(x >> 1, y >> 1) << 1;
    if ((x & 1) == 0) return gcdRecursive(x >> 1, y);
    if ((y & 1) == 0) return gcdRecursive(x, y >> 1);
    if (x > y) return gcdRecursive(x - y, y);
    return gcdRecursive(x, y - x);
  }

  public static int gcdSimple(int a, int b) {
    while (b > 0) {
      int temp = b;
      b = a % b;
      a = temp;
    }
    return a;
  }
}
