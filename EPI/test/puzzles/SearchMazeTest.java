package puzzles;

import org.junit.Test;
import puzzles.SearchMaze.Point;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static puzzles.SearchMaze.checkPath;
import static puzzles.SearchMaze.searchMaze;

public class SearchMazeTest {

  @Test
  public void testSearchMaze() throws Exception {
    List<List<Integer>> maze =
        Arrays.asList(
            Arrays.asList(1, 0, 0, 0, 0, 0, 1, 1, 0, 0),
            Arrays.asList(0, 0, 1, 0, 0, 0, 0, 0, 0, 0),
            Arrays.asList(1, 0, 1, 0, 0, 1, 1, 0, 1, 1),
            Arrays.asList(0, 0, 0, 1, 1, 1, 0, 0, 1, 0),
            Arrays.asList(0, 1, 1, 0, 0, 0, 0, 0, 0, 0),
            Arrays.asList(0, 1, 1, 0, 0, 1, 0, 1, 1, 0),
            Arrays.asList(0, 0, 0, 0, 1, 0, 0, 0, 0, 0),
            Arrays.asList(1, 0, 1, 0, 1, 0, 1, 0, 0, 0),
            Arrays.asList(1, 0, 1, 1, 0, 0, 0, 1, 1, 1),
            Arrays.asList(0, 0, 0, 0, 0, 0, 0, 1, 1, 0));
    List<List<Integer>> originalMaze = new ArrayList<>();
    for (List<Integer> row : maze) originalMaze.add(new ArrayList<>(row));

    Point start = new Point(9, 0), stop = new Point(0, 9);
    List<Point> path = searchMaze(maze, start, stop);
    System.out.println(path);
    assert path != null && !path.isEmpty();
    assert checkPath(path, originalMaze, start, stop);
  }
}
