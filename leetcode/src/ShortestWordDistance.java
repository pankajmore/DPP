/** https://leetcode.com/problems/shortest-word-distance Created by pankaj on 30/07/17. */
class ShortestWordDistance {
  int shortestDistance(final String[] words, final String word1, final String word2) {
    int idx1 = -1, idx2 = -1, min = Integer.MAX_VALUE;
    for (int i = 0; i < words.length; i++) {
      String word = words[i];
      if (word1.equals(word)) {
        idx1 = i;
      }
      if (word2.equals(word)) {
        idx2 = i;
      }
      if (idx1 != -1 && idx2 != -1) {
        min = Math.min(min, Math.abs(idx1 - idx2));
      }
    }
    return min;
  }
}
