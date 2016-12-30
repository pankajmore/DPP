import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * https://leetcode.com/problems/pascals-triangle/
 * Created by pankaj on 30/12/16.
 */
public class PascalsTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> rows = new ArrayList<>();
        if (numRows == 0) return rows;
        rows.add(Collections.singletonList(1));
        for (int i = 1; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                row.add((j == 0 ? 0 : rows.get(i - 1).get(j - 1)) + (j == i ? 0 : rows.get(i - 1).get(j)));
            }
            rows.add(row);
        }
        return rows;
    }
}
