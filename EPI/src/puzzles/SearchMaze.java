package puzzles;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/** Created by Pankaj on 9/24/15. */
public class SearchMaze {
  public static List<Point> searchMaze(List<List<Integer>> maze, Point start, Point stop) {
    LinkedList<Point> path = new LinkedList<>();
    maze.get(start.x).set(start.y, 1);
    path.addFirst(start);
    if (!searchMazeHelper(maze, start, stop, path)) path.removeLast();
    return path;
  }

  private static boolean searchMazeHelper(
      List<List<Integer>> maze, Point curr, Point stop, LinkedList<Point> path) {
    if (curr.equals(stop)) return true;
    for (Point child : children(curr, maze)) {
      maze.get(child.x).set(child.y, 1);
      path.add(child);
      if (searchMazeHelper(maze, child, stop, path)) return true;
      path.removeLast();
    }
    return false;
  }

  private static List<Point> children(Point curr, List<List<Integer>> maze) {
    List<? extends List<Integer>> shift =
        Arrays.asList(
            Arrays.asList(0, -1), Arrays.asList(0, 1),
            Arrays.asList(-1, 0), Arrays.asList(1, 0));
    LinkedList<Point> children = new LinkedList<>();
    for (List<Integer> s : shift) {
      Point child = new Point(curr.x + s.get(0), curr.y + s.get(1));
      if (isFeasible(child, maze)) children.add(child);
    }
    return children;
  }

  private static boolean isFeasible(Point point, List<List<Integer>> maze) {
    return point.x >= 0
        && point.x < maze.size()
        && point.y >= 0
        && point.y < maze.get(point.x).size()
        && maze.get(point.x).get(point.y) == 0;
  }

  public static boolean checkPath(
      List<Point> path, List<List<Integer>> maze, Point start, Point stop) {
    if (path.isEmpty()) return true;
    if (!path.get(0).equals(start)) return false;
    for (int i = 1; i < path.size(); i++) {
      Point prev = path.get(i - 1);
      Point curr = path.get(i);
      if (!children(prev, maze).contains(curr)) return false;
    }
    if (!path.get(path.size() - 1).equals(stop)) return false;
    return true;
  }

  public static final class Point {
    public int x, y;

    public Point(int x, int y) {
      this.x = x;
      this.y = y;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      Point that = (Point) o;
      return (this.x == that.x && this.y == that.y);
    }

    @Override
    public String toString() {
      return String.format("(%d,%d)", this.x, this.y);
    }
  }
}
