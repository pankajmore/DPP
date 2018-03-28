/** https://leetcode.com/problems/number-of-lines-to-write-string/description/ */
class NumberOfLinesToWriteString {
  int[] numberOfLines(int[] widths, String S) {
    int numLines = 1;
    int cnt = 0;
    for (char c : S.toCharArray()) {
      int w = widths[c - 'a'];
      if (cnt + w <= 100) {
        cnt = cnt + w;
      } else {
        numLines = numLines + 1;
        cnt = w;
      }
    }
    return new int[] {numLines, cnt};
  }
}
