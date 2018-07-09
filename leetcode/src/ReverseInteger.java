/** https://leetcode.com/problems/reverse-integer/ Created by pankaj on 9/23/16. */
public class ReverseInteger {
  public int reverse(int x) {
    int r = 0;
    while (x != 0) {
      int temp = (r * 10) + (x % 10);
      if (temp / 10 != r) return 0; // handle overflow
      r = temp;
      x /= 10;
    }
    return r;
  }
}
