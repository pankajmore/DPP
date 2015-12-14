package puzzles;

import utils.Pair;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Pankaj on 12/14/15.
 */
public class StringInMatrix {
    /**
     * Time: O(nml)
     * Space: O(nml)
     *
     * @param A the 2D grid to search in
     * @param S the sequence of values to search for
     * @return the list of points if there exists a path in A that matches S
     * else null
     */
    public static List<Pair<Integer, Integer>> match(int[][] A, int[] S) {
        int m = A.length, n = A[0].length, l = S.length;
        boolean[][][] C = new boolean[l][m][n];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                C[0][i][j] = A[i][j] == S[0];

        for (int k = 1; k < l; k++)
            for (int i = 0; i < m; i++)
                for (int j = 0; j < n; j++)
                    C[k][i][j] = A[i][j] == S[k] &&
                            (find(C, k - 1, i - 1, j) || find(C, k - 1, i, j - 1) || find(C, k - 1, i + 1, j) || find(C, k - 1, i, j + 1));

        List<Pair<Integer, Integer>> path = new ArrayList<>();
        Pair<Integer, Integer> curr = find(C, l - 1);
        if (curr == null) return null;
        path.add(curr);
        for (int k = l - 2; k >= 0; k--) {
            curr = find(C, k, curr);
            if (curr == null) return path;
            path.add(curr);
        }
        Collections.reverse(path);
        return path;
    }

    private static Pair<Integer, Integer> find(boolean[][][] C, int k, Pair<Integer, Integer> p) {
        if (k < 0) return null;
        int i = p.first(), j = p.second();
        if (find(C, k, i - 1, j)) return new Pair<>(i - 1, j);
        if (find(C, k, i, j - 1)) return new Pair<>(i, j - 1);
        if (find(C, k, i + 1, j)) return new Pair<>(i + 1, j);
        if (find(C, k, i, j + 1)) return new Pair<>(i, j + 1);
        return null;
    }

    private static Pair<Integer, Integer> find(boolean[][][] C, int k) {
        for (int i = 0; i < C[0].length; i++)
            for (int j = 0; j < C[0][0].length; j++)
                if (C[k][i][j]) return new Pair<>(i, j);
        return null;
    }

    private static boolean find(boolean[][][] C, int k, int i, int j) {
        return i < 0 || i >= C[0].length || j < 0 || j >= C[0][0].length ? false : C[k][i][j];
    }
}
