/** https://leetcode.com/problems/count-primes/ Created by pankaj on 10/02/17. */
public class CountPrimes {
  public int countPrimes(int N) {
    int cnt = 0;
    boolean[] A = new boolean[N];
    for (int i = 2; i * i < N; i++) {
      if (A[i]) continue;
      for (int j = i * i; j < N; j += i) {
        A[j] = true;
      }
    }
    for (int i = 2; i < N; i++) {
      if (!A[i]) cnt++;
    }
    return cnt;
  }
}
