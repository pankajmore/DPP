package puzzles;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/** Created by Pankaj on 11/22/15. */
public class PrimeSieve {
  public static List<Integer> generatePrimes(int n) {
    List<Integer> primes = new ArrayList<>();
    int kSize = (n - 3) / 2 + 1;
    List<Boolean> isPrime = new ArrayList<>(Collections.nCopies(kSize, true));
    primes.add(2);
    for (long i = 0; i < kSize; i++) {
      if (!isPrime.get((int) i)) continue;
      long p = 2 * i + 3;
      primes.add((int) p);
      for (long j = 2 * i * i + 6 * i + 3; j < kSize; j += p) isPrime.set((int) j, false);
    }
    return primes;
  }
}
