package puzzles;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by pankaj on 1/27/16.
 */
public class Triangle {
    /**
     * Time: O(N)
     * Space: O(N)
     *
     * @param triangle a pascal triangle of height N
     * @return the minimum path sum from top to bottom
     */
    public static int minPathSum(final List<List<Integer>> triangle) {
        List<Integer> dp = new ArrayList<>(triangle.get(triangle.size() - 1));
        for (int row = triangle.size() - 2; row >= 0; row--) {
            for (int col = 0; col < dp.size() - 1; col++) {
                int min = Math.min(dp.get(col), dp.get(col + 1));
                dp.set(col, min + triangle.get(row).get(col));
            }
            dp.remove(dp.size() - 1);
        }
        assert dp.size() == 1;
        return dp.get(0);
    }

    /**
     * Time: O(N)
     * Space: O(N^2)
     *
     * @param triangle a pascal triangle of height N
     * @return a path representing the minimum sum from top to bottom
     */
    public static List<Integer> minPath(final List<List<Integer>> triangle) {
        List<List<Integer>> dp = new ArrayList<>();
        int rows = triangle.size();
        dp.add(triangle.get(0)); //adds first row verbatim
        for (int row = 1; row < rows; row++) {
            List<Integer> currRow = new ArrayList<>();
            int cols = triangle.get(row).size();
            for (int col = 0; col < cols; col++)
                currRow.add(triangle.get(row).get(col) + Math.min(col == 0 ? Integer.MAX_VALUE : dp.get(row - 1).get(col - 1),
                        col >= cols - 1 ? Integer.MAX_VALUE : dp.get(row - 1).get(col)));
            dp.add(currRow);
        }
        int minWeight = Collections.min(dp.get(rows - 1));
        int minCol = dp.get(rows - 1).indexOf(minWeight);
        List<Integer> minPath = new ArrayList<>();
        minPath.add(triangle.get(rows - 1).get(minCol));
        for (int row = rows - 2; row >= 0; row--) {
            if (minCol == 0) {
                minPath.add(triangle.get(row).get(minCol));
                continue;
            }
            if (dp.get(row).get(minCol) > dp.get(row).get(minCol - 1)) {
                minCol--;
            }
            minPath.add(triangle.get(row).get(minCol));
        }
        Collections.reverse(minPath);
        assert minPath.size() == rows;
        return minPath;
    }
}
