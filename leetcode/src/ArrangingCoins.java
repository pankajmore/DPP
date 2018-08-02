/** https://leetcode.com/contest/11/problems/arranging-coins/ Created by pankaj on 10/31/16. */
class ArrangingCoins {
  int arrangeCoins(int n) {
    int i = 0;
    while (n >= 0) {
      i += 1;
      n -= i;
    }
    return i - 1;
  }

  public int arrangeCoins1(int n) {
    return (int) ((Math.sqrt(1 + 8 * (long) n) - 1.0) / 2.0);
  }
}
