/**
 * https://leetcode.com/problems/arithmetic-slices/
 * Created by pankaj on 20/02/17.
 */
public class ArithmeticSlices {
    public int numberOfArithmeticSlices(int[] A) {
        int N = A.length;
        int cnt = 0, x = 0;
        for (int i = 2; i < N; i++) {
            if (A[i] - A[i - 1] == A[i - 1] - A[i - 2]) x++;
            else x = 0;
            cnt += x;
        }
        return cnt;
    }
}
