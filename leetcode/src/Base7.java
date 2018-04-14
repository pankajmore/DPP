/**
 * https://leetcode.com/contest/leetcode-weekly-contest-19/problems/base-7/ Created by pankaj on
 * 12/02/17.
 */
class Base7 {
  String convertTo7(int num) {
    if (num == 0) return "0";
    boolean neg = num < 0;
    if (num < 0) num = -num;
    StringBuilder sb = new StringBuilder();
    while (num > 0) {
      sb.append(num % 7);
      num /= 7;
    }
    return neg ? "-" + sb.reverse().toString() : sb.reverse().toString();
  }
}
