package puzzles;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/** Created by Pankaj on 12/15/15. */
public class WordBreaking {
  /**
   * Time: O(s.length()^2) Space: O(s.length()^2)
   *
   * @param s the string to break
   * @param dict the dictionary of words
   * @return List of sequence of words which concatenate to s if such a list exists else null
   */
  public static List<String> wordBreaking(String s, Set<String> dict) {
    boolean[][] subStringCache = cacheSubStringLookup(s, dict);
    boolean[] solutions = buildSolutionDP(s, subStringCache);
    return backtrack(s, subStringCache, solutions);
  }

  private static boolean[][] cacheSubStringLookup(String s, Set<String> dict) {
    Set<List<Character>> dictOfChars = new HashSet<>();
    for (String d : dict) {
      List<Character> chars = new ArrayList<>();
      for (Character c : d.toCharArray()) {
        chars.add(c);
      }
      dictOfChars.add(chars);
    }
    int N = s.length();
    boolean[][] cache = new boolean[N][N];
    for (int i = 0; i < N; i++) {
      List<Character> chars = new ArrayList<>();
      for (int j = i; j < N; j++) {
        chars.add(s.charAt(j));
        cache[i][j] = dictOfChars.contains(chars);
      }
    }
    return cache;
  }

  private static List<String> backtrack(String s, boolean[][] subStringCache, boolean[] solutions) {
    int N = s.length();
    if (!solutions[N]) return null;
    List<String> words = new ArrayList<>();
    int start = 0, end = 0;
    while (++end <= N) {
      if (solutions[end] && subStringCache[start][end - 1]) {
        words.add(s.substring(start, end));
        start = end;
      }
    }
    return words;
  }

  private static boolean[] buildSolutionDP(String s, boolean[][] subStringCache) {
    int N = s.length();
    boolean[] dp = new boolean[N + 1];
    dp[0] = true;
    for (int i = 1; i <= N; i++) {
      for (int k = 0; k < i; k++) {
        if (dp[k] && subStringCache[k][i - 1]) {
          dp[i] = true;
          break;
        }
      }
    }
    return dp;
  }
}
