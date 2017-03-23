package puzzles;

import org.junit.Test;
import puzzles.NQueens.ChessGrid;

import java.util.Arrays;
import java.util.List;

public class ChessGridTest {

  @Test
  public void testRotations() {
    int[][] a = {
      {0, 0, 1, 0}, {1, 0, 0, 0}, {0, 0, 0, 1}, {0, 1, 0, 0},
    };
    int[][] b = {
      {1, 0, 0, 0, 0}, {0, 0, 1, 0, 0}, {0, 0, 0, 0, 1}, {0, 1, 0, 0, 0}, {0, 0, 0, 1, 0}
    };
    List<ChessGrid> grids = Arrays.asList(new ChessGrid(a), new ChessGrid(b));
    for (ChessGrid grid : grids) {
      assert Arrays.deepEquals(grid.rotateBy90().rotateBy270().grid(), grid.grid());
      assert Arrays.deepEquals(grid.rotateBy180().rotateBy180().grid(), grid.grid());
      assert Arrays.deepEquals(grid.flipLeftDiagonal().flipLeftDiagonal().grid(), grid.grid());
      assert !Arrays.deepEquals(grid.flipLeftDiagonal().grid(), grid.grid());
      assert Arrays.deepEquals(grid.flipRightDiagonal().flipRightDiagonal().grid(), grid.grid());
      assert !Arrays.deepEquals(grid.flipRightDiagonal().grid(), grid.grid());
      assert !Arrays.deepEquals(grid.reflectHorizontal().grid(), grid.grid());
      assert Arrays.deepEquals(grid.reflectHorizontal().reflectHorizontal().grid(), grid.grid());
    }
  }

  @Test
  public void testEquals() throws Exception {
    int[][] a = {
      {0, 0, 1, 0}, {1, 0, 0, 0}, {0, 0, 0, 1}, {0, 1, 0, 0},
    };
    int[][] b = {
      {0, 1, 0, 0}, {0, 0, 0, 1}, {1, 0, 0, 0}, {0, 0, 1, 0},
    };
    ChessGrid grid1 = new ChessGrid(a);
    ChessGrid grid2 = new ChessGrid(b);
    assert grid1.equals(grid2);
  }
}
