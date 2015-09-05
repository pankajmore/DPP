package puzzles;

/**
 * Created by Pankaj on 9/5/15.
 */
public class BinomialCoefficients {
    public static int nCkRecursive(int n, int k) {
        if (n == k || k == 0) return 1;
        return nCkRecursive(n - 1, k) + nCkRecursive(n - 1, k - 1);
    }

    public static int nCk(int n, int k) {
        int A[] = new int[n + 1];
        for (int i = 0; i <= n; i++) A[i] = 1;
        for (int j = 1; j <= k; j++) {
            for (int i = 1; i <= n; i++) {
                A[i] += A[i - 1];
            }
        }
        return A[n];
    }
}
