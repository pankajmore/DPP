package dailycodingproblem;

/**
 * Suppose you have a multiplication table that is N by N. That is, a 2D array where the value at
 * the i-th row and j-th column is (i + 1) * (j + 1) (if 0-indexed) or i * j (if 1-indexed).
 *
 * <p>Given integers N and X, write a function that returns the number of times X appears as a value
 * in an N by N multiplication table.
 */
class DCP74 {
  static int numberOfTimesInATable(int n, int x) {
    int cnt = 0;
    for (int i = 1; i <= n; i++) {
      if (x % i == 0 && x <= i * n) {
        cnt++;
      }
    }
    return cnt;
  }
}
