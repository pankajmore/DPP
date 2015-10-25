package puzzles;

/**
 * Created by Pankaj on 10/25/15.
 */
public class MonotonicDecimals {
    public static int numberOfMonotonicDecimals(int length) {
        if (length == 0) return 0;
        int[] C = new int[10];
        for (int i = 0; i < 10; i++) C[i] = i;
        for (int k = 2; k <= length; k++) {
            for (int i = 2; i < 10; i++) {
                C[i] += C[i - 1];
            }
        }
        return C[9];
    }
}
