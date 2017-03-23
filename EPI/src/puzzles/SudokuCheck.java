package puzzles;

import java.util.List;

/** Created by Pankaj on 9/30/15. */
public class SudokuCheck {
  public static boolean isValidSudoku(List<List<Integer>> partialAssignment) {
    for (int i = 0; i < partialAssignment.size(); i++)
      if (!valid(partialAssignment, i, i + 1, 0, partialAssignment.size())) return false;
    for (int i = 0; i < partialAssignment.size(); i++)
      if (!valid(partialAssignment, 0, partialAssignment.size(), i, i + 1)) return false;
    int regionSize = (int) Math.sqrt(partialAssignment.size());
    for (int i = 0; i < regionSize; i++)
      for (int j = 0; j < regionSize; j++)
        if (!valid(
            partialAssignment,
            regionSize * i,
            regionSize * (i + 1),
            regionSize * j,
            regionSize * (j + 1))) return false;
    return true;
  }

  private static boolean valid(
      List<List<Integer>> A, int startRow, int endRow, int startCol, int endCol) {
    boolean[] v = new boolean[A.size() + 1];
    for (int row = startRow; row < endRow; row++) {
      for (int col = startCol; col < endCol; col++) {
        if (A.get(row).get(col) != 0 && v[A.get(row).get(col)]) return false;
        v[A.get(row).get(col)] = true;
      }
    }
    return true;
  }
}
