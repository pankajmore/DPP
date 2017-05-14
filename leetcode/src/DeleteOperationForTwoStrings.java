/**
 * https://leetcode.com/problems/delete-operation-for-two-strings/ Created by pankaj on 14/05/17.
 */
class DeleteOperationForTwoStrings {
  int minDistance(final String word1, final String word2) {
    int m = word1.length();
    int n = word2.length();
    int[][] lcs = new int[m + 1][n + 1];
    for (int i = 1; i <= m; i++) {
      for (int j = 1; j <= n; j++) {
        if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
          lcs[i][j] = lcs[i - 1][j - 1] + 1;
        } else {
          lcs[i][j] = Math.max(lcs[i - 1][j], lcs[i][j - 1]);
        }
      }
    }
    return m + n - 2 * lcs[m][n];
  }
}
