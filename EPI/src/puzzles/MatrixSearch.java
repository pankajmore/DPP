package puzzles;

/**
 * Created by Pankaj on 1/4/16.
 */
public class MatrixSearch {
    public static boolean matrixSearch(int[][] A, int x) {
        if (A.length == 0) return false;
        int m = A.length, n = A[0].length;
        int i = 0, j = n - 1;
        while (i < m && j >= 0) {
            if (A[i][j] == x) return true;
            if (A[i][j] < x) i++;
            else j--;
        }
        return false;
    }
}
