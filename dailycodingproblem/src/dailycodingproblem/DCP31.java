package dailycodingproblem;

import com.sun.istack.internal.NotNull;

/**
 * The edit distance between two strings refers to the minimum number of character insertions,
 * deletions, and substitutions required to change one string to the other.
 */
class DCP31 {
    static int minDistance(@NotNull String word1, @NotNull String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] min = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 && j == 0) {
                    min[i][j] = 0;
                } else if (i == 0 || j == 0) {
                    min[i][j] = i + j;
                } else {
                    if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                        min[i][j] = min[i - 1][j - 1];
                    } else {
                        min[i][j] = Math.min(Math.min(min[i - 1][j - 1], min[i - 1][j]), min[i][j - 1]) + 1;
                    }
                }
            }
        }
        return min[m][n];
    }
}
