package puzzles;

import java.util.ArrayList;
import java.util.List;

/** Created by Pankaj on 11/22/15. */
public class LookAndSay {
  public static String lookAndSay(int n) {
    String s = "1";
    for (int i = 2; i <= n; i++) s = next(s);
    return s;
  }

  public static List<String> lookAndSayList(int n) {
    List<String> l = new ArrayList<>();
    String s = "1";
    l.add(s);
    for (int i = 2; i <= n; i++) {
      s = next(s);
      l.add(s);
    }
    return l;
  }

  private static String next(String s) {
    StringBuilder sb = new StringBuilder();
    int count = 1;
    for (int i = 1; i < s.length(); i++) {
      if (s.charAt(i) != s.charAt(i - 1)) {
        sb.append(count);
        sb.append(s.charAt(i - 1));
        count = 1;
      } else count++;
    }
    sb.append(count);
    sb.append(s.charAt(s.length() - 1));
    return sb.toString();
  }
}
