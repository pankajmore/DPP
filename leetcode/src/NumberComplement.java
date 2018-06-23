/** https://leetcode.com/problems/number-complement/ Created by pankaj on 27/01/17. */
public class NumberComplement {
  public int findComplement(int num) {
    int mask = 0, n = num;
    while (n > 0) {
      n >>>= 1;
      mask = (mask << 1) + 1;
    }
    return ~num & mask;
  }
}
