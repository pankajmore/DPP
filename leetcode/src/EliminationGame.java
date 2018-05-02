/** https://leetcode.com/contest/2/problems/elimination-game/ Created by pankaj on 8/28/16. */
public class EliminationGame {
  public int lastRemaining(int n) {
    return f(n, true);
  }

  public int f(int n, boolean left) {
    if (n == 1) return 1;
    if (left) return 2 * f(n / 2, false);
    else return n + 1 - f(n, true);
  }

  public int lastRemaining1(int n) {
    int head = 1, remaining = n, step = 1;
    boolean left = true;
    while (remaining > 1) {
      if (left || remaining % 2 == 1) {
        head = head + step;
      }
      remaining >>= 1;
      step <<= 1;
      left = !left;
    }
    return head;
  }

  public int lastRemaining2(int n) {
    return 1 + ((Integer.highestOneBit(n) - 1) & (0x55555555 | n));
  }
}
