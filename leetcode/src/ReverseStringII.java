/** https://leetcode.com/problems/reverse-string-ii/ Created by pankaj on 12/03/17. */
public class ReverseStringII {
  public String reverseStr(String s, int k) {
    if (k <= 0) return s;
    StringBuilder sb = new StringBuilder();
    int N = s.length();
    int c = 0;
    for (int i = 0; i < N; i += k) {
      int num = Math.min(k, N - i);
      if (c % 2 == 0) append(sb, s, Math.min(i + k - 1, N - 1), num, true);
      else append(sb, s, i, num, false);
      c++;
    }
    return sb.toString();
  }

  private void append(StringBuilder sb, String s, int idx, int k, boolean reverse) {
    while (k-- > 0) {
      sb.append(s.charAt(idx));
      idx = reverse ? idx - 1 : idx + 1;
    }
  }
}
