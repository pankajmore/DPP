/** https://leetcode.com/problems/factorial-trailing-zeroes/ Created by pankaj on 27/12/16. */
public class FactorialTrailingZeroes {
  public int trailingZeroes(int n) {
    int numFives = 0;
    while (n > 0) {
      n /= 5;
      numFives += n;
    }
    return numFives;
  }
}
