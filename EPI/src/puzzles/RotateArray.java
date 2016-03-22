package puzzles;


import org.jetbrains.annotations.NotNull;

/**
 * Created by pankaj on 3/22/16.
 * Rotate any array by k
 */
public class RotateArray {
    /**
     * Time : O(N)
     * Space: O(1)
     *
     * @param A an array of size N
     * @param k an integer
     */
    public static void rotateArray(@NotNull int[] A, int k) {
        if (A.length == 0 || k % A.length == 0) return;
        int N = A.length;
        k %= N;
        reverse(A, 0, N);
        reverse(A, 0, k);
        reverse(A, k, N);
    }

    /**
     * Time : O(N)
     * Space: O(1)
     *
     * @param A an array of size N
     * @param k an integer
     */
    public static void rotateArray1(@NotNull int[] A, int k) {
        if (A.length == 0 || k % A.length == 0) return;
        int N = A.length, start = 0, curr = 0, nextElem = A[start];
        k %= N;
        for (int i = 0; i < N; i++) {
            int temp = A[(curr + k) % N];
            A[(curr + k) % N] = nextElem;
            nextElem = temp;
            curr = (curr + k) % N;
            if (curr == start) {
                curr = ++start;
                nextElem = A[start];
            }
        }
    }

    private static void reverse(int[] A, int start, int end) {
        for (int i = start, j = end - 1; i < j; i++, j--) {
            int temp = A[i];
            A[i] = A[j];
            A[j] = temp;
        }
    }
}
