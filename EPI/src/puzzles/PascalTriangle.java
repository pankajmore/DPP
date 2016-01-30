package puzzles;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pankaj on 1/30/16.
 */
public class PascalTriangle {
    public static List<List<Integer>> pascalTriangle(int n) {
        List<List<Integer>> rows = new ArrayList<>();
        List<Integer> row = new ArrayList<>();
        row.add(1);
        rows.add(row);
        for (int i = 1; i < n; i++) {
            row = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                row.add((j == 0 ? 0 : rows.get(i - 1).get(j - 1)) + (j == i ? 0 : rows.get(i - 1).get(j)));
            }
            rows.add(row);
        }
        return rows;
    }
}
