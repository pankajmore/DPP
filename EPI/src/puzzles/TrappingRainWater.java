package puzzles;

/**
 * Created by Pankaj on 9/12/15.
 */
public class TrappingRainWater {
    /**
     * Time : O(n)
     * Space : O(n)
     *
     * @param A array of non-negative integers
     * @return the capacity of the 1-D tank with unit width rectangle and height from A
     */
    public static int capacity(int[] A) {
        int N = A.length;
        int[] L, R, H;
        L = new int[N + 2];
        H = new int[N + 2];
        R = new int[N + 2];
        for (int i = 1; i <= N; i++) H[i] = A[i - 1];
        for (int i = 1; i <= N; i++) {
            L[i] = Math.max(L[i - 1], H[i]);
            R[N - i + 1] = Math.max(R[N - i + 2], H[N - i + 1]);
        }
        int c = 0;
        for (int i = 1; i <= N; i++) {
            c += Math.max(Math.min(L[i - 1], R[i + 1]) - H[i], 0);
        }
        return c;
    }

    //TODO: implement O(1) space optimized solution
}
