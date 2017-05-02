package com.dpp.geeksforgeeks;

/**
 * http://www.geeksforgeeks.org/probability-knight-remain-chessboard/ Created by pankaj on 02/05/17.
 */
final class ProbabilityOfKnightToRemainInChessBoard {

  /** The positions that a Knight can move. */
  private static final int[][] DIRS = {
    {-2, -1}, {-2, 1}, {-1, -2}, {-1, 2}, {1, -2}, {1, 2}, {2, -1}, {2, 1}
  };

  /** Total number of moves in 1 step. */
  private static final int KNIGHT_MOVES = DIRS.length;

  /** Don't let anyone instantiate this class. */
  private ProbabilityOfKnightToRemainInChessBoard() {}

  /**
   * The knight cannot come back once it goes out of chessboard (0,0) is top-left.
   *
   * @param x initial x co-ordinate
   * @param y initial y co-ordinate
   * @param n size of chessboard is nxn
   * @param k number of steps taken by knight
   * @return the probability of knight remaining in chessboard after k steps
   */
  static double findProbability(final int x, final int y, final int n, final int k) {
    if (!inside(x, y, n)) {
      return 0.0;
    }
    long[][][] prob = new long[k + 1][n][n];
    prob[0][x][y] = 1L;
    for (int step = 1; step <= k; step++) {
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
          for (int[] d : DIRS) {
            int ii = i + d[0];
            int jj = j + d[1];
            if (inside(ii, jj, n)) {
              prob[step][i][j] += prob[step - 1][ii][jj];
            }
          }
        }
      }
    }
    return sum(prob[k]) / Math.pow(KNIGHT_MOVES, k);
  }

  static double findProbability1(final int x, final int y, final int n, final int k) {
    if (!inside(x, y, n)) {
      return 0.0;
    }
    double[][][] prob = new double[k + 1][n][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        prob[0][i][j] = 1.0;
      }
    }
    for (int step = 1; step <= k; step++) {
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
          for (int[] d : DIRS) {
            int ii = i + d[0];
            int jj = j + d[1];
            if (inside(ii, jj, n)) {
              prob[step][i][j] = prob[step][i][j] + (prob[step - 1][ii][jj] / KNIGHT_MOVES);
            }
          }
        }
      }
    }
    return prob[k][x][y];
  }

  /**
   * @param matrix input
   * @return sum of the values
   */
  private static double sum(final long[][] matrix) {
    long sum = 0L;
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[i].length; j++) {
        sum += matrix[i][j];
      }
    }
    return sum;
  }

  private static boolean inside(final int x, final int y, final int n) {
    return x >= 0 && x < n && y >= 0 && y < n;
  }
}
