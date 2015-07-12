package puzzles;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by pankajm on 5/30/15.
 */
// TODO: incomplete
public class OfflineSampling {
    public int[] sample(int[] A, int k)
    {
        int N = A.length;
        Random r = new Random();
        boolean reverse = false;
        if( k > N/2) {
            k = N - k;
            reverse = true;
        }
        for(int j=0;j<k;j++) {
            int i = r.nextInt(N - 1 - j);
            swap(A[i], A[N - 1 - j]);
        }
        if(reverse)
            return Arrays.copyOfRange(A, 0, N-k);
        else
            return Arrays.copyOfRange(A, N-k, N-1);
    }

    private void swap(int x, int y) {
        x = x^y;
        y = x^y;
        x = x^y;
    }

}
