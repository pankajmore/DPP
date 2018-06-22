/** https://leetcode.com/problems/nim-game/ Created by pankaj on 10/4/16. */
public class NimGame {
  public boolean canWinNim(int n) {
    return (n & 0b11) != 0;
  }
}
