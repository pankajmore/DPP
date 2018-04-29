/** https://leetcode.com/problems/counting-bits/ Created by pankaj on 9/30/16. */
public class CountingBits {
  public int[] countBits(int num) {
    int[] f = new int[num + 1];
    f[0] = 0;
    for (int i = 1; i <= num; i++) f[i] = f[i >>> 1] + (i & 1);
    return f;
  }
}
