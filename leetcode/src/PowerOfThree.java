/** https://leetcode.com/problems/power-of-three/ Created by pankaj on 20/12/16. */
public class PowerOfThree {
  public boolean isPowerOfThree(int n) {
    return n > 0 && 1162261467 % n == 0;
  }
}
