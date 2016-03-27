public class TheNicePair {

    public int solve(int[] A) {
        int N = A.length, best = -1;
        for (int d = 2; d <= 1000; d++) {
            int c = 0;
            for (int i = 0; i < N; i++) {
                c = 0;
                for (int j = i; j < N; j++) {
                    if (A[j] % d == 0) c++;
                    if (2 * c >= (j - i + 1)) best = Math.max(best, j - i);
                }
            }
        }
        return best;
    }
}
