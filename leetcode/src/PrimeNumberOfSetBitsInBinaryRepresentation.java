import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/** https://leetcode.com/problems/prime-number-of-set-bits-in-binary-representation/description/ */
class PrimeNumberOfSetBitsInBinaryRepresentation {
  int countPrimeSetBits(int L, int R) {
    Set<Integer> primes = new HashSet<>(Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31));
    int cnt = 0;
    for (int i = L; i <= R; i++) {
      int ones = ones(i);
      if (primes.contains(ones)) {
        cnt++;
      }
    }
    return cnt;
  }

  private int ones(int n) {
    int cnt = 0;
    while (n > 0) {
      n &= n - 1;
      cnt++;
    }
    return cnt;
  }
}
