package puzzles;

import static java.lang.Math.min;

/**
 * Created by Pankaj on 9/5/15.
 */
public class BinomialCoefficients {
    /**
     * Time Complexity : Exponential
     * Space : O(n)
     *
     * @param n
     * @param k
     * @return n Choose k
     */
    public static int nCkRecursive(int n, int k) {
        if (n < k) return 0;
        if (n == k || k == 0) return 1;
        if (k > n / 2) k = n - k;
        return nCkRecursive(n - 1, k) + nCkRecursive(n - 1, k - 1);
    }

    /**
     * Time Complexity : O(n*k)
     * Space : O(k)
     *
     * @param n
     * @param k
     * @return n Choose k
     */
    public static int nCk(int n, int k) {
        if (n < k) return 0;
        if (k > n / 2) k = n - k;
        int A[] = new int[k + 1];
        A[0] = 1;
        for (int i = 1; i <= n; i++)
            for (int j = min(i, k); j > 0; j--) A[j] += A[j - 1];
        return A[k];
    }
}
