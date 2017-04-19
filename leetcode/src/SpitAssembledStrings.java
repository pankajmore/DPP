/** https://leetcode.com/problems/split-assembled-strings/ Created by pankaj on 19/04/17. */
public class SpitAssembledStrings {
  public String splitLoopedString(String[] strs) {
    int N = strs.length;
    for (int i = 0; i < N; i++) strs[i] = larger(strs[i]);
    String best = null;
    for (int i = 0; i < N; i++) {
      String str = strs[i];
      for (int j = 0; j < str.length(); j++) {
        String s2 = str.substring(0, j);
        String s1 = str.substring(j, str.length());
        StringBuilder rest = new StringBuilder();
        for (int k = (i + 1) % N; k != i; k = (k + 1) % N) {
          rest.append(strs[k]);
        }
        String x = new StringBuilder().append(s1).append(rest).append(s2).toString();
        String y =
            new StringBuilder()
                .append(new StringBuilder().append(s2).reverse().toString())
                .append(rest)
                .append(new StringBuilder().append(s1).reverse().toString())
                .toString();
        if (best == null || best.compareTo(x) < 0) best = x;
        if (best.compareTo(y) < 0) best = y;
      }
    }
    return best;
  }

  public String larger(String s) {
    String r = new StringBuilder().append(s).reverse().toString();
    return s.compareTo(r) > 0 ? s : r;
  }
}
