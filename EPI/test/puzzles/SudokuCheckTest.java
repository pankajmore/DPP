package puzzles;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class SudokuCheckTest {

  @Test
  public void testIsValidSudoku() throws Exception {
    List<List<Integer>> A =
        Arrays.asList(
            Arrays.asList(0, 2, 6, 0, 0, 0, 8, 1, 0),
            Arrays.asList(3, 0, 0, 7, 0, 8, 0, 0, 6),
            Arrays.asList(4, 0, 0, 0, 5, 0, 0, 0, 7),
            Arrays.asList(0, 5, 0, 1, 0, 7, 0, 9, 0),
            Arrays.asList(0, 0, 3, 9, 0, 5, 1, 0, 0),
            Arrays.asList(0, 4, 0, 3, 0, 2, 0, 5, 0),
            Arrays.asList(1, 0, 0, 0, 3, 0, 0, 0, 2),
            Arrays.asList(5, 0, 0, 2, 0, 4, 0, 0, 9),
            Arrays.asList(0, 3, 8, 0, 0, 0, 4, 6, 0));
    assert SudokuCheck.isValidSudoku(A) == true;
  }
}
