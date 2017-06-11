/**
 * https://leetcode.com/problems/design-compressed-string-iterator/ Created by pankaj on 11/06/17.
 */
class DesignCompressedStringIterator {
  class StringIterator {
    private String s;
    private int idx, cnt;
    private char curr;

    StringIterator(final String compressedString) {
      s = compressedString;
      idx = 0;
      cnt = 0;
    }

    char next() {
      if (!hasNext()) {
        return ' ';
      }
      cnt--;
      return curr;
    }

    boolean hasNext() {
      if (cnt == 0) {
        if (idx == s.length()) {
          return false;
        }
        curr = s.charAt(idx++);
        while (idx < s.length() && Character.isDigit(s.charAt(idx))) {
          cnt = cnt * 10 + (s.charAt(idx) - '0');
          idx++;
        }
      }
      return true;
    }
  }

  /**
   * Your StringIterator object will be instantiated and called as such: StringIterator obj = new
   * StringIterator(compressedString); char param_1 = obj.next(); boolean param_2 = obj.hasNext();
   */
}
