package puzzles;

import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Created by pankajm on 5/30/15.
 */
public class OfflineSampling {
    public static List<Integer> sample(List<Integer> A, int k) {
        Random r = new Random();
        for (int i = 0; i < k; i++) Collections.swap(A, i, i + r.nextInt(A.size() - i));
        return A.subList(0, k);
    }
}
