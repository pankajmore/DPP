package puzzles;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by pankaj on 3/22/16.
 */
public class CollatzConjecture {
    public static boolean testCollatzConjecture(int n) throws Exception {
        Set<Long> set = new HashSet<>();
        for (int i = 2; i <= n; i++) {
            Set<Long> seq = new HashSet<>();
            long x = (long) i;
            while (x >= i) {
                if (!seq.add(x)) {
                    return false;
                }
                if ((x & 1) == 1) {
                    if (!set.add(x)) break;
                    long nextX = x * 3 + 1;
                    if (nextX < x) throw new ArithmeticException("Overflow when checking n = " + i);
                    x = nextX;
                } else {
                    x >>>= 2;
                }
            }
        }
        return true;
    }
}
