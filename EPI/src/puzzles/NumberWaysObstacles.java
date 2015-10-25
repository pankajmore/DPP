package puzzles;

/**
 * Created by Pankaj on 10/25/15.
 */
public class NumberWaysObstacles {
    public static int numberOfWaysWithObstacles(boolean[][] B) {
        if (B.length == 0 || B[0][0]) return 0;
        int m = B.length, n = B[0].length;
        int[] C = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (B[i][j]) C[j] = 0;
                else {
                    if (i == 0 || j == 0) C[j] = 1;
                    else C[j] += C[j - 1];
                }
            }
        }
        return C[n - 1];
    }
}
