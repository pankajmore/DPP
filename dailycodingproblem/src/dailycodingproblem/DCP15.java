package dailycodingproblem;

import java.util.Iterator;
import java.util.Random;

/**
 * Given a stream of elements too large to store in memory, pick a random element from the stream
 * with uniform probability.
 */
class DCP15 {
    static Integer reservoirSampling(Iterator<Integer> it) {
        Integer e = null;
        int n = 0;
        Random rng = new Random();
        while (it.hasNext()) {
            Integer i = it.next();
            n++;
            if (rng.nextInt(n) == 0) {
                e = i;
            }
        }
        return e;
    }
}
