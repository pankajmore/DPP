package puzzles;

import java.util.*;

/** Created by Pankaj on 9/25/15. */
public class TransformStringToOther {
  /**
   * Time : O(N^2) Space: O(N)
   *
   * @param s source string of constant size
   * @param t destination string of constant size
   * @param D set of N strings in the dictionary
   * @return the length of the sequence from s to t in D
   */
  public static int shortestProductionSequence(String s, String t, Set<String> D) {
    Set<String> visited = new HashSet<>();
    Map<String, Integer> distance = new HashMap<>();
    Queue<String> q = new LinkedList<>();
    if (s.length() != t.length()) return -1;
    if (!D.contains(s) || !D.contains(t)) return -1;
    q.add(s);
    distance.put(s, 1);
    while (!q.isEmpty()) {
      String n = q.poll();
      visited.add(n);
      if (n.equals(t)) return distance.get(n);
      for (String child : children(n, D)) {
        if (!visited.contains(child)) {
          q.add(child);
          distance.put(child, distance.get(n) + 1);
        }
      }
    }
    return -1;
  }

  private static List<String> children(String s, Set<String> D) {
    int N = s.length();
    List<String> children = new ArrayList<>();
    for (int i = 0; i < N; i++) {
      String left = s.substring(0, i), right = s.substring(i + 1, N);
      for (char c = 'a'; c <= 'z'; c++) {
        String x = left + c + right;
        if (D.contains(x)) children.add(x);
      }
    }
    return children;
  }
}
