package puzzles;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Pankaj on 10/23/15.
 */
public class NQueens {
    public static List<List<String>> allNQueens(int n) {
        List<List<String>> grids = new ArrayList<>();
        nQueens(Arrays.asList(), n, grids);
        return grids;
    }

    private static void nQueens(List<String> grid, int n, List<List<String>> grids) {
        if (grid.size() == n) grids.add(grid);
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

    private static void print(List<String> grid) {
        grid.forEach(System.out::println);
        System.out.println();
    }

    public static void main(String[] args) {
        allNQueens(5);
    }
}
