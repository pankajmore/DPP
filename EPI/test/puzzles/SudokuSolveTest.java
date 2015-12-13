package puzzles;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static puzzles.SudokuSolve.solveSudoku;

public class SudokuSolveTest {

    @Test
    public void testSolveSudoku() throws Exception {
        List<List<Integer>> A =
                Arrays.asList(Arrays.asList(0, 2, 6, 0, 0, 0, 8, 1, 0),
                        Arrays.asList(3, 0, 0, 7, 0, 8, 0, 0, 6),
                        Arrays.asList(4, 0, 0, 0, 5, 0, 0, 0, 7),
                        Arrays.asList(0, 5, 0, 1, 0, 7, 0, 9, 0),
                        Arrays.asList(0, 0, 3, 9, 0, 5, 1, 0, 0),
                        Arrays.asList(0, 4, 0, 3, 0, 2, 0, 5, 0),
                        Arrays.asList(1, 0, 0, 0, 3, 0, 0, 0, 2),
                        Arrays.asList(5, 0, 0, 2, 0, 4, 0, 0, 9),
                        Arrays.asList(0, 3, 8, 0, 0, 0, 4, 6, 0));
        assert solveSudoku(A);
        List<List<Integer>> goldenA =
                Arrays.asList(Arrays.asList(7, 2, 6, 4, 9, 3, 8, 1, 5),
                        Arrays.asList(3, 1, 5, 7, 2, 8, 9, 4, 6),
                        Arrays.asList(4, 8, 9, 6, 5, 1, 2, 3, 7),
                        Arrays.asList(8, 5, 2, 1, 4, 7, 6, 9, 3),
                        Arrays.asList(6, 7, 3, 9, 8, 5, 1, 2, 4),
                        Arrays.asList(9, 4, 1, 3, 6, 2, 7, 5, 8),
                        Arrays.asList(1, 9, 4, 8, 3, 6, 5, 7, 2),
                        Arrays.asList(5, 6, 7, 2, 1, 4, 3, 8, 9),
                        Arrays.asList(2, 3, 8, 5, 7, 9, 4, 6, 1));
        assert A.equals(goldenA);
    }
}