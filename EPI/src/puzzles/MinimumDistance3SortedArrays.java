package puzzles;

import java.util.List;

/**
 * Created by pankaj on 2/25/16.
 */
public class MinimumDistance3SortedArrays {
    /**
     * Return the minDistance = Min(|A[i] - B[j]|, |B[j] - C[k]|, |C[k] - A[i]|) for all i,j,k
     * <p>
     * Time : O(N_A + N_B + N_C)
     * Space: O(1)
     *
     * @param A list of size N_A
     * @param B list of size N_B
     * @param C list of size N_C
     * @return
     */
    public static int minimumDistance(List<Integer> A, List<Integer> B, List<Integer> C) {
        int i = 0, j = 0, k = 0;
        int minDistance = Integer.MAX_VALUE;
        while (i < A.size() || j < B.size() || k < C.size()) {
            minDistance = Math.min(minDistance, Math.max(Math.abs(A.get(i) - B.get(j)),
                    Math.max(Math.abs(B.get(j) - C.get(k)), Math.abs(C.get(k) - A.get(i)))));
            int min = Math.min(A.get(i), Math.min(B.get(j), C.get(k)));
            if (i < A.size() && min == A.get(i)) i++;
            else if (j < B.size() && min == B.get(j)) j++;
            else k++;
        }
        return minDistance;
    }
}
