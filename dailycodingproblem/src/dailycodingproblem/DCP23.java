package dailycodingproblem;

import java.util.Deque;
import java.util.LinkedList;

/**
 * You are given an M by N matrix consisting of booleans that represents a board. Each True boolean
 * represents a wall. Each False boolean represents a tile you can walk on.
 *
 * <p>
 *
 * <p>Given this matrix, a start coordinate, and an end coordinate, return the minimum number of
 * steps required to reach the end coordinate from the start. If there is no possible path, then
 * return null. You can move up, left, down, and right. You cannot move through walls. You cannot
 * wrap around the edges of the board.
 */
class DCP23 {
  static int[][] DIRS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

  static int minSteps(boolean[][] grid, int x1, int y1, int x2, int y2) {
    if (grid == null || grid.length == 0 || grid[0].length == 0) {
      return 0;
    }
    int m = grid.length;
    int n = grid[0].length;
    boolean[][] visited = new boolean[m][n];
    Deque<Point> queue = new LinkedList<>();
    Point start = new Point(x1, y1);
    Point end = new Point(x2, y2);
    queue.add(start);
    queue.add(null);
    int dist = 0;
    while (!queue.isEmpty()) {
      Point p = queue.remove();
      if (p == null) {
        queue.add(null);
        dist++;
      } else if (p.equals(end)) {
        return dist;
      } else {
        int x = p.x;
        int y = p.y;
        for (int[] dir : DIRS) {
          int xx = x + dir[0];
          int yy = y + dir[1];
          if (xx >= 0 && xx < m && yy >= 0 && yy < n && !grid[xx][yy] && !visited[xx][yy]) {
            queue.add(new Point(xx, yy));
            visited[xx][yy] = true;
          }
        }
      }
    }
    return -1;
  }

  private static class Point {
    private int x;
    private int y;

    private Point(int x, int y) {
      this.x = x;
      this.y = y;
    }

    @Override
    public boolean equals(Object o) {
      if (o == null || !(o instanceof Point)) {
        return false;
      }
      Point p = (Point) o;
      return this.x == p.x && this.y == p.y;
    }
  }
}
