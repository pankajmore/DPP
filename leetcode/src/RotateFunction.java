/**
 * https://leetcode.com/problems/rotate-function/
 * Created by pankaj on 9/14/16.
 */
public class RotateFunction {
    public int maxRotateFunction(int[] A) {
        int x = 0, max, N = A.length;
        int sum = 0;
        for (int i = 0; i < N; i++) {
            x += i * A[i];
            sum += A[i];
        }
        max = x;
        for (int i = 0; i < N; i++) {
            x = x - sum + N * A[i];
            max = Math.max(max, x);
        }
        return max;
    }
}
