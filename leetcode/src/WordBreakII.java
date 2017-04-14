/** https://leetcode.com/problems/word-break-ii/ Created by pankaj on 14/04/17. */
public class WordBreakII {
  public List<String> wordBreak(String s, List<String> wordDict) {
    Set<String> dict = new HashSet<>(wordDict);
    Map<String, List<String>> cache = new HashMap<>();
    return wordBreakHelper(s, dict, cache);
  }

  private List<String> wordBreakHelper(
      String s, Set<String> dict, Map<String, List<String>> cache) {
    if (s.isEmpty()) {
      List<String> l = new ArrayList<>();
      l.add("");
      return l;
    }
    if (!cache.containsKey(s)) {
      int N = s.length();
      List<String> l = new ArrayList<>();
      for (int i = 0; i < N; i++) {
        String sub = s.substring(0, i + 1);
        if (dict.contains(sub)) {
          String rest = i == N - 1 ? "" : s.substring(i + 1, N);
          List<String> remaining = wordBreakHelper(rest, dict, cache);
          for (String r : remaining) {
            l.add(r.isEmpty() ? sub : sub + " " + r);
          }
        }
      }
      cache.put(s, l);
    }
    return cache.get(s);
  }
}
