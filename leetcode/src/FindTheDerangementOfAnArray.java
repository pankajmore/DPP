/**
 * https://leetcode.com/problems/find-the-derangement-of-an-array/ Created by pankaj on 03/07/17.
 */
class FindTheDerangementOfAnArray {
  private static final int MOD = 1000000007;

  int findDerangement(final int n) {
    if (n == 0) {
      return 1;
    }
    if (n == 1) {
      return 0;
    }
    int a = 1;
    int b = 0;
    for (int i = 2; i <= n; i++) {
      int tmp = (a + b) % MOD;
      tmp = (int) (((i - 1L) * tmp) % MOD);
      a = b;
      b = tmp;
    }
    return b;
  }
}
