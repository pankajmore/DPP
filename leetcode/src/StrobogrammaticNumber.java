/** https://leetcode.com/problems/strobogrammatic-number Created by pankaj on 31/07/17. */
class StrobogrammaticNumber {
  boolean isStrobogrammatic(final String num) {
    for (int i = 0, j = num.length() - 1; i <= j; i++, j--) {
      char x = num.charAt(i);
      char y = num.charAt(j);
      if (!((x == 1 && y == 1)
          || (x == 0 && y == 0)
          || (x == 8 && y == 8)
          || (x == 6 && y == 9)
          || (x == 9 && y == 6))) {
        return false;
      }
    }
    return true;
  }
}
