import java.util.ArrayList;
import java.util.List;

/** https://leetcode.com/problems/output-contest-matches/ Created by pankaj on 22/03/17. */
public class OutputContestMatches {
  public String findContestMatch(int n) {
    List<String> l = new ArrayList<>();
    for (int i = 1; i <= n; i++) l.add(Integer.toString(i));
    while (n > 1) {
      for (int i = 0; i < n / 2; i++) {
        String s = "(" + l.get(i) + ',' + l.get(n - i - 1) + ')';
        l.set(i, s);
      }
      n /= 2;
    }
    return l.get(0);
  }
}
