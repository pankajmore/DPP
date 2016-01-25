package puzzles;

import puzzles.SearchMaze.Point;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by pankaj on 1/25/16.
 */
public class FishingTrip {
    /**
     * The fisherman can only go right or down.
     * Time : O(mn)
     * Space : O(n)
     *
     * @param lake a grid of size m x n, each cell -> non-negative fish value
     * @return the maximum value captured along a path
     */
    public static int maximumFish(List<List<Integer>> lake) {
        int m = lake.size(), n = lake.get(0).size();
        int[] dp = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[j] = Math.max(i == 0 ? 0 : dp[j], j == 0 ? 0 : dp[j - 1]) + lake.get(i).get(j);
            }
        }
        return dp[n - 1];
    }

    /**
     * The fisherman can only go right or down.
     * Time : O(mn)
     * Space : O(mn)
     *
     * @param lake a grid of size m x n, each cell -> non-negative fish value
     * @return the path with the maximum value
     */
    public static List<Point> maximumFishPath(List<List<Integer>> lake) {
        int m = lake.size(), n = lake.get(0).size();
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = Math.max(i == 0 ? 0 : dp[i - 1][j], j == 0 ? 0 : dp[i][j - 1]) + lake.get(i).get(j);
            }
        }
        List<Point> path = new ArrayList<>();
        path.add(new Point(m - 1, n - 1));
        for (int i = m - 1, j = n - 1; i != 0 || j != 0; ) {
            if (i == 0) path.add(new Point(i, --j));
            else if (j == 0) path.add(new Point(--i, j));
            else if (dp[i - 1][j] > dp[i][j - 1]) path.add(new Point(--i, j));
            else path.add(new Point(i, --j));
        }
        Collections.reverse(path);
        assert path.size() == m + n - 1;
        return path;
    }


}
