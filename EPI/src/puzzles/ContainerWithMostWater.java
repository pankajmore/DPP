package puzzles;

import java.util.List;

/**
 * Created by Pankaj on 11/3/15.
 */
public class ContainerWithMostWater {
    /**
     * Time : O(n)
     * Space : O(1)
     * <p>
     * Invariant Property :
     * If A[0] < A[n-1], for all x area(0,x) <= area(0,n-1),
     * we can discard A[0].
     * If A[0] > A[n-1], for all x area(x,n-1) <= area(0,n-1),
     * we can discard A[n-1]
     * If A[0] == A[n-1], we can discard both
     *
     * @param heights the list of heights of vertical lines
     * @return the maximum amount of water that can be filled between
     * and two vertical lines
     */
    public static int getMaxArea(List<Integer> heights) {
        int N = heights.size(), i = 0, j = N - 1, maxArea = 0;
        while (i < j) {
            maxArea = Math.max(maxArea, Math.min(heights.get(i), heights.get(j)) * (j - i));
            if (heights.get(i) < heights.get(j)) ++i;
            else if (heights.get(i) > heights.get(j)) --j;
            else {
                ++i;
                --j;
            }
        }
        return maxArea;
    }

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
