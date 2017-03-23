package puzzles;

import java.util.Random;

/** Created by pankaj on 3/23/16. Implement a hash function for chess */
public class ZobristHashing {
  private final int[][] _board;
  private final int[][][] _code;
  private int _hash;

  /**
   * Time : O(MN) Space: O(MN)
   *
   * @param board takes a board of size M x N
   * @param numberOfDifferentPieces the number of possible values in each cell
   */
  public ZobristHashing(int[][] board, int numberOfDifferentPieces) {
    this._board = board;
    _code = new int[board.length][board[0].length][numberOfDifferentPieces];
    initializeCode();
    _hash = buildHash();
  }

  private int buildHash() {
    int hash = 0;
    for (int i = 0; i < _board.length; i++) {
      for (int j = 0; j < _board[0].length; j++) {
        hash ^= _code[i][j][_board[i][j]];
      }
    }
    return hash;
  }

  private void initializeCode() {
    Random r = new Random();
    for (int i = 0; i < _code.length; i++) {
      for (int j = 0; j < _code[0].length; j++) {
        for (int c = 0; c < _code[0][0].length; c++) {
          _code[i][j][c] = r.nextInt();
        }
      }
    }
  }

  /**
   * Recompute the hash incrementally when a piece moves Assumes that (x1,y1) has a piece and
   * (x2,y2) is empty And 0th piece denotes empty cell Time : O(1) Space: O(1)
   *
   * @param x1 the x coordinate of src
   * @param y1 the y coordinate of src
   * @param x2 the x coordinate of destination
   * @param y2 the y coordinate of destination
   */
  public void move(int x1, int y1, int x2, int y2) {
    int piece = _board[x1][y1];
    _hash ^= _code[x1][y1][piece] ^ _code[x1][y1][0] ^ _code[x2][y2][0] ^ _code[x2][y2][piece];
  }

  /**
   * Time : O(1) Space: O(1)
   *
   * @return the hashCode of the current board state
   */
  public int hash() {
    return _hash;
  }
}
