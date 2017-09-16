/**
 * https://leetcode.com/problems/add-binary/
 * Created by pankaj on 02/02/17.
 */
class AddBinary {
  String addBinary(final String a, final String b) {
    int M = a.length(), N = b.length();
    int carry = 0;
    StringBuilder sb = new StringBuilder();
    for (int i = M - 1, j = N - 1; i >= 0 || j >= 0; i--, j--) {
      int x = i < 0 ? 0 : a.charAt(i) - '0';
      int y = j < 0 ? 0 : b.charAt(j) - '0';
      sb.append(x ^ y ^ carry);
      carry = (x + y + carry) / 2;
    }
    if (carry == 1) sb.append(1);
    return sb.reverse().toString();
  }
}
