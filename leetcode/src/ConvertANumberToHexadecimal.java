/** https://leetcode.com/problems/convert-a-number-to-hexadecimal/ Created by pankaj on 19/12/16. */
class ConvertANumberToHexadecimal {
  String toHex(int num) {
    if (num == 0) return "0";
    StringBuilder sb = new StringBuilder();
    while (num != 0) {
      int d = num & 0xf;
      sb.append(d < 10 ? (char) (d + '0') : (char) (d - 10 + 'a'));
      num >>>= 4;
    }
    return sb.reverse().toString();
  }
}
