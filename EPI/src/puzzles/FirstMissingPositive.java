package puzzles;

/**
 * Created by pankaj on 2/15/16.
 */
public class FirstMissingPositive {
    /**
     * Time : O(N)
     * Space : O(N)
     *
     * @param A array of size N
     * @return the first positive integer missing in A
     */
    public static int findFirstMissingPositiveEntry(int[] A) {
        int N = A.length;
        int[] B = new int[N + 1];
        for (int i = 0; i < N; i++) {
            if (A[i] > 0 && A[i] <= N) B[A[i] - 1] = 1;
        }
        for (int i = 0; i <= N; i++) if (B[i] == 0) return i + 1;
        return N + 1;
    }
}
