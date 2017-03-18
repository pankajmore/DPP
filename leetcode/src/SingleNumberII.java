/** https://leetcode.com/problems/single-number-ii/ Created by pankaj on 18/03/17. */
public class SingleNumberII {
  public int singleNumber(int[] nums) {
    int mask = 1;
    int res = 0;
    for (int i = 0; i < Integer.SIZE; i++) {
      int cnt = 0;
      for (int x : nums) {
        cnt += (x & mask) != 0 ? 1 : 0;
      }
      int d = cnt % 3;
      assert d <= 1;
      if (d == 1) {
        res |= mask;
      }
      mask <<= 1;
    }
    return res;
  }
}
