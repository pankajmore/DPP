/**
 * https://leetcode.com/problems/arithmetic-slices/
 * Created by pankaj on 20/02/17.
 */
public class ArithmeticSlices {
    public int numberOfArithmeticSlices(int[] A) {
        int N = A.length;
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i + 2; j < N; j++) {
                if (A[j] - A[j - 1] == A[j - 1] - A[j - 2]) cnt++;
                else break;
            }
        }
        return cnt;
    }
}
