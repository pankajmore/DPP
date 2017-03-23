package puzzles;

import java.util.List;

/** Created by Pankaj on 12/13/15. */
public class SudokuSolve {
  private static final int EMPTY_CELL = 0;

  public static boolean solveSudoku(List<List<Integer>> partialAssignment) {
    return solvePartialSudoku(partialAssignment, 0, 0);
  }

  private static boolean solvePartialSudoku(List<List<Integer>> partialAssignment, int i, int j) {
    if (j == partialAssignment.get(i).size()) {
      j = 0;
      if (++i == partialAssignment.size()) return true;
    }

    if (partialAssignment.get(i).get(j) != EMPTY_CELL)
      return solvePartialSudoku(partialAssignment, i, j + 1);

    for (int val = 1; val <= partialAssignment.size(); val++) {
      if (checkPositionWithVal(partialAssignment, i, j, val)) {
        partialAssignment.get(i).set(j, val);
        if (solvePartialSudoku(partialAssignment, i, j + 1)) return true;
      }
    }
    partialAssignment.get(i).set(j, EMPTY_CELL);
    return false;
  }

  private static boolean checkPositionWithVal(
      List<List<Integer>> partialAssignment, int i, int j, int val) {
    for (Integer col : partialAssignment.get(i)) if (col.equals(val)) return false;
    for (List<Integer> row : partialAssignment) if (row.get(j).equals(val)) return false;
    int regionSize = (int) Math.sqrt(partialAssignment.size());
    int I = i / regionSize, J = j / regionSize;
    for (int a = 0; a < regionSize; a++)
      for (int b = 0; b < regionSize; b++)
        if (partialAssignment.get(regionSize * I + a).get(regionSize * J + b).equals(val))
          return false;
    return true;
  }
}
