package puzzles;

import java.util.List;

/**
 * Created by Pankaj on 11/3/15.
 */
public class ContainerWithMostWater {
    /**
     * Time : O(n^2)
     * Space : O(1)
     *
     * @param heights the list of heights of vertical lines
     * @return the maximum amount of water that can be filled between
     * and two vertical lines
     */
    public static int getMaxAreaBruteForce(List<Integer> heights) {
        int maxArea = 0, N = heights.size();
        for (int i = 0; i < N; i++)
            for (int j = i + 1; j < N; j++) {
                int currArea = Math.min(heights.get(i), heights.get(j)) * (j - i);
                if (currArea > maxArea) maxArea = currArea;
            }
        return maxArea;
    }
}
