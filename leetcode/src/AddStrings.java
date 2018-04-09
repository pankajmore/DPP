/** https://leetcode.com/problems/add-strings Created by pankaj on 10/9/16. */
public class AddStrings {
  public String addStrings(String num1, String num2) {
    int M = num1.length(), N = num2.length();
    int i, j, d1, d2, s, carry = 0;
    StringBuilder sb = new StringBuilder();
    for (i = M - 1, j = N - 1; i >= 0 || j >= 0 || carry > 0; i--, j--) {
      d1 = i < 0 ? 0 : num1.charAt(i) - '0';
      d2 = j < 0 ? 0 : num2.charAt(j) - '0';
      s = (d1 + d2 + carry) % 10;
      carry = (d1 + d2 + carry) / 10;
      sb.append(s);
    }
    return sb.reverse().toString();
  }
}
