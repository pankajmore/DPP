package puzzles;

import utils.Pair;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/** Created by Pankaj on 12/14/15. */
public class StringInMatrix {
  /**
   * Time: O(nml) Space: O(nml)
   *
   * @param A the 2D grid to search in
   * @param S the sequence of values to search for
   * @return the list of points if there exists a path in A that matches S else null
   */
  public static List<Pair<Integer, Integer>> match(int[][] A, int[] S) {
    int m = A.length, n = A[0].length, l = S.length;
    boolean[][][] C = new boolean[l][m][n];
    for (int i = 0; i < m; i++) for (int j = 0; j < n; j++) C[0][i][j] = A[i][j] == S[0];

    for (int k = 1; k < l; k++)
      for (int i = 0; i < m; i++)
        for (int j = 0; j < n; j++)
          C[k][i][j] =
              A[i][j] == S[k]
                  && (find(C, k - 1, i - 1, j)
                      || find(C, k - 1, i, j - 1)
                      || find(C, k - 1, i + 1, j)
                      || find(C, k - 1, i, j + 1));

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
      for (int j = 0; j < C[0][0].length; j++) if (C[k][i][j]) return new Pair<>(i, j);
    return null;
  }

  private static boolean find(boolean[][][] C, int k, int i, int j) {
    return i < 0 || i >= C[0].length || j < 0 || j >= C[0][0].length ? false : C[k][i][j];
  }

  /**
   * @param board a MxN board of chars
   * @param word the string to search for
   * @return true if the string can be traced in board, a cell may not be repeated in the trace
   */
  public static boolean exist(char[][] board, String word) {
    if (board.length == 0 || board[0].length == 0) return false;
    int M = board.length;
    int N = board[0].length;
    boolean[][] visited = new boolean[M][N];
    for (int i = 0; i < M; i++) {
      for (int j = 0; j < N; j++) {
        if (existHelper(board, word, 0, i, j, visited)) return true;
      }
    }
    return false;
  }

  private static boolean existHelper(
      char[][] board, String word, int idx, int i, int j, boolean[][] visited) {
    if (idx == word.length()) return true;
    if (i < 0
        || i >= board.length
        || j < 0
        || j >= board[0].length
        || visited[i][j]
        || board[i][j] != word.charAt(idx)) return false;
    visited[i][j] = true;
    if (existHelper(board, word, idx + 1, i - 1, j, visited)
        || existHelper(board, word, idx + 1, i + 1, j, visited)
        || existHelper(board, word, idx + 1, i, j - 1, visited)
        || existHelper(board, word, idx + 1, i, j + 1, visited)) return true;
    visited[i][j] = false;
    return false;
  }
}
