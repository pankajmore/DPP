package puzzles;

import puzzles.SearchMaze.Point;

import java.util.ArrayList;
import java.util.List;

/** Created by pankaj on 3/12/16. */
public class SurroundedRegions {
  /**
   * Time : O(MN) Space: O(MN)
   *
   * @param board a 2D grid of size M x N
   */
  public void fillSurroundedRegions(List<List<Character>> board) {
    if (board.size() == 0 || board.get(0).size() == 0) return;
    int M = board.size(), N = board.get(0).size();
    boolean[][] visited = new boolean[M][N];
    for (int i = 1; i < M; i++) {
      for (int j = 1; j < N; j++) {
        if (!visited[i][j] && board.get(i).get(j) == 'W') {
          markRegionIfSurrounded(i, j, board, visited);
        }
      }
    }
  }

  private void markRegionIfSurrounded(
      int i, int j, List<List<Character>> board, boolean[][] visited) {
    List<Point> q = new ArrayList<>();
    q.add(new Point(i, j));
    visited[i][j] = true;
    int idx = 0, M = board.size(), N = board.get(0).size();
    boolean isSurrounded = true;
    while (idx < q.size()) {
      Point p = q.get(idx++);
      if (p.x == 0 || p.x == M - 1 || p.y == 0 || p.y == N - 1) {
        isSurrounded = false;
      } else {
        int[][] DIRS = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for (int[] d : DIRS) {
          Point next = new Point(p.x + d[0], p.y + d[1]);
          if (!visited[next.x][next.y] && board.get(next.x).get(next.y) == 'W') {
            visited[next.x][next.y] = true;
            q.add(next);
          }
        }
      }
    }
    if (isSurrounded) {
      for (Point p : q) {
        board.get(p.x).set(p.y, 'B');
      }
    }
  }
}
