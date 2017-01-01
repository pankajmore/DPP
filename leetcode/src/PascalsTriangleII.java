import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/pascals-triangle-ii/
 * Created by pankaj on 01/01/17.
 */
public class PascalsTriangleII {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<>();
        if (rowIndex < 0) return row;
        for (int i = 0; i <= rowIndex; i++) row.add(0);
        row.set(0, 1);
        for (int i = 1; i <= rowIndex; i++) {
            for (int j = i; j >= 1; j--) {
                row.set(j, row.get(j - 1) + (j == i ? 0 : row.get(j)));
            }
        }
        return row;
    }
}
