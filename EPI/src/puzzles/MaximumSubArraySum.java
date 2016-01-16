package puzzles;

import puzzles.SubseqCover.SubArray;

import java.util.List;

/**
 * Created by pankaj on 1/16/16.
 */
public class MaximumSubArraySum {
    /**
     * Time : O(N)
     * Space : O(1)
     *
     * @param A a list of N integers
     * @return the sub-array [i,j] such that sum(A[i..j-1]) is maximum
     */
    public static SubArray findMaximumSumSubArray(List<Integer> A) {
        int N = A.size(), min_s = 0, min_i = -1, s = 0, best_sum = 0;
        SubArray bestSubArray = new SubArray(0, 0);
        for (int i = 0; i < N; i++) {
            s += A.get(i);
            if (s < min_s) {
                min_s = s;
                min_i = i;
            }
            if (s - min_s > best_sum) {
                best_sum = s - min_s;
                bestSubArray = new SubArray(min_i + 1, i + 1);
            }
        }
        return bestSubArray;
    }
}
