package puzzles;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Pankaj on 11/22/15.
 */
public class PrimeSieve {
    public static List<Integer> generatePrimes(int n) {
        List<Integer> primes = new ArrayList<>();
        List<Boolean> isPrime = new ArrayList<>(Collections.nCopies(n + 1, true));
        isPrime.set(0, false);
        isPrime.set(1, false);
        for (int i = 2; i <= n; i++) {
            if (!isPrime.get(i))
                continue;
            primes.add(i);
            for (long j = (long) i * (long) i; j <= n; j += i) isPrime.set((int) j, false);
        }
        return primes;
    }
}
