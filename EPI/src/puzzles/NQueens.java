package puzzles;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Pankaj on 10/23/15.
 */
public class NQueens {
    public static List<ChessGrid> allNQueens(int n) {
        List<ChessGrid> grids = new ArrayList<>();
        nQueens(Arrays.asList(), n, grids);
        return grids;
    }

    public static List<ChessGrid> allNQueensFundamental(int n) {
        return allNQueens(n).stream().distinct().collect(Collectors.toList());
        //return new HashSet<>(allNQueens(n));
    }

    public static void printAllNQueens(int n) {
        for (ChessGrid grid : allNQueens(n)) {
            System.out.println(grid.toString());
        }

    }

    private static void nQueens(List<String> grid, int n, List<ChessGrid> grids) {
        if (grid.size() == n) grids.add(new ChessGrid(grid));
        for (int i = 0; i < n; i++) {
            String row = getRow(i, n);
            List<String> newGrid = extend(grid, row);
            if (valid(newGrid))
                nQueens(newGrid, n, grids);
        }
    }

    private static boolean valid(List<String> grid) {
        int n = grid.get(0).length();
        int x = grid.size() - 1;
        int y = grid.get(x).indexOf('Q');
        int c = y, d = y;
        for (int row = 0; row < x; row++)
            if (grid.get(row).charAt(y) == 'Q')
                return false;
        for (int row = x - 1; row >= 0; row--) {
            if (++c < n && grid.get(row).charAt(c) == 'Q')
                return false;
            if (--d >= 0 && grid.get(row).charAt(d) == 'Q')
                return false;
        }
        return true;
    }

    private static List<String> extend(List<String> grid, String row) {
        List<String> newGrid = new ArrayList<>();
        grid.forEach(newGrid::add);
        newGrid.add(row);
        return newGrid;
    }

    private static String getRow(int k, int n) {
        StringBuilder sb = new StringBuilder(n);
        for (int i = 0; i < n; i++) sb.append('+');
        sb.setCharAt(k, 'Q');
        return sb.toString();
    }

    public static void main(String[] args) {
        printAllNQueens(5);
    }

    public static class ChessGrid {
        private final int[][] _grid;
        private final int _N;

        public ChessGrid(int[][] grid) {
            _grid = grid;
            _N = _grid.length;
        }

        public ChessGrid(List<String> grid) {
            _N = grid.size();
            _grid = new int[_N][_N];
            for (int i = 0; i < _N; i++)
                for (int j = 0; j < _N; j++)
                    _grid[i][j] = grid.get(i).charAt(j) == 'Q' ? 1 : 0;
        }

        public int[][] grid() {
            return _grid;
        }

        public ChessGrid rotateBy90() {
            int[][] rotatedGrid = new int[_N][_N];
            for (int i = 0; i < _N; i++) for (int j = 0; j < _N; j++) rotatedGrid[i][j] = _grid[_N - j - 1][i];
            return new ChessGrid(rotatedGrid);
        }

        public ChessGrid rotateBy180() {
            return this.rotateBy90().rotateBy90();
        }

        public ChessGrid rotateBy270() {
            return rotateBy90().rotateBy180();
        }

        public ChessGrid reflectHorizontal() {
            int[][] newGrid = new int[_N][_N];
            for (int i = 0; i < _N; i++) newGrid[i] = _grid[_N - 1 - i];
            return new ChessGrid(newGrid);
        }

        public ChessGrid flipLeftDiagonal() {
            int[][] rotatedGrid = new int[_N][_N];
            for (int i = 0; i < _N; i++) System.arraycopy(_grid[i], 0, rotatedGrid[i], 0, _N);
            for (int i = 0; i < _N; i++)
                for (int j = 0; j < i; j++) {
                    int temp = rotatedGrid[j][i];
                    rotatedGrid[j][i] = rotatedGrid[i][j];
                    rotatedGrid[i][j] = temp;
                }
            return new ChessGrid(rotatedGrid);
        }

        public ChessGrid flipRightDiagonal() {
            int[][] rotatedGrid = new int[_N][_N];
            for (int i = 0; i < _N; i++) System.arraycopy(_grid[i], 0, rotatedGrid[i], 0, _N);
            for (int i = 0; i < _N; i++)
                for (int j = i; j < _N; j++) {
                    int temp = rotatedGrid[_N - 1 - i][_N - 1 - j];
                    rotatedGrid[_N - 1 - i][_N - 1 - j] = rotatedGrid[_N - 1 - j][_N - 1 - i];
                    rotatedGrid[_N - 1 - j][_N - 1 - i] = temp;
                }
            return new ChessGrid(rotatedGrid);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < _N; i++) {
                for (int j = 0; j < _N; j++) sb.append(_grid[i][j]);
                sb.append("\n");
            }
            return sb.toString();
        }

        public int hashCode() {
            return 0;
        }

        public boolean equals(Object o) {
            if (!(o instanceof ChessGrid)) return false;
            ChessGrid that = (ChessGrid) o;
            return Arrays.deepEquals(this._grid, that._grid)
                    || Arrays.deepEquals(this.rotateBy90()._grid, that._grid)
                    || Arrays.deepEquals(this.rotateBy180()._grid, that._grid)
                    || Arrays.deepEquals(this.rotateBy270()._grid, that._grid)
                    || Arrays.deepEquals(this.reflectHorizontal()._grid, that._grid)
                    //|| Arrays.deepEquals(this.flipRightDiagonal()._grid, that._grid)
                    || Arrays.deepEquals(this.rotateBy90().reflectHorizontal()._grid, that._grid)
                    || Arrays.deepEquals(this.rotateBy180().reflectHorizontal()._grid, that._grid)
                    || Arrays.deepEquals(this.rotateBy270().reflectHorizontal()._grid, that._grid);
        }
    }
}
