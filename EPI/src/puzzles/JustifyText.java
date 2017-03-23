package puzzles;

import java.util.ArrayList;
import java.util.List;

/** Created by pankaj on 2/29/16. */
public class JustifyText {
  /**
   * Time : O(N) Space: O(N)
   *
   * @param text a text containing N words
   * @param width the target number of columns to justify in
   * @return a list of lines, each line is fully justified, last line is left justified.
   */
  public static List<String> justifyText(String[] text, int width) {
    List<String> list = new ArrayList<>();
    int N = text.length;
    for (int start = 0, end; start < N; start = end) {
      int len = -1;
      for (end = start; end < N && len + text[end].length() + 1 <= width; end++) {
        len += text[end].length() + 1;
      }
      int space = 1, extra = 0;
      if (end != start + 1 && end != N) {
        space = (width - len) / (end - start - 1) + 1;
        extra = (width - len) % (end - start - 1);
      }
      StringBuilder sb = new StringBuilder();
      sb.append(text[start]);
      for (int i = start + 1; i < end; i++) {
        for (int sp = space; sp > 0; sp--) sb.append(' ');
        if (extra-- > 0) sb.append(' ');
        sb.append(text[i]);
      }
      int strLen = width - sb.length();
      while (strLen-- > 0) sb.append(' ');
      list.add(sb.toString());
    }
    return list;
  }
}
