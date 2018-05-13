/**
 * https://leetcode.com/contest/leetcode-weekly-contest-13/problems/hamming-distance/ Created by
 * pankaj on 18/12/16.
 */
public class HammingDistance {
  public int hammingDistance(int x, int y) {
    int cnt = 0, z = x ^ y;
    while (z > 0) {
      z = z & (z - 1);
      cnt++;
    }
    return cnt;
  }
}
