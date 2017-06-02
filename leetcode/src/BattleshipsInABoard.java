/** https://leetcode.com/problems/battleships-in-a-board/ Created by pankaj on 02/06/17. */
class BattleshipsInABoard {
  int countBattleships(final char[][] board) {
    int cnt = 0;
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[i].length; j++) {
        if (board[i][j] == 'X'
            && (i == 0 || board[i - 1][j] != 'X')
            && (j == 0 || board[i][j - 1] != 'X')) {
          cnt++;
        }
      }
    }
    return cnt;
  }
}
