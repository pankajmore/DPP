/**
 * https://leetcode.com/problems/beautiful-arrangement/
 * Created by pankaj on 22/02/17.
 */
public class BeautifulArrangement {
    public int countArrangement(int N) {
        int[] A = new int[N];
        for (int i = 0; i < N; i++) A[i] = i + 1;
        return count(N, A);
    }

    private int count(int N, int[] A) {
        if (N <= 0) return 1;
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            if (A[i] % N == 0 || N % A[i] == 0) {
                swap(A, i, N - 1);
                cnt += count(N - 1, A);
                swap(A, i, N - 1);
            }
        }
        return cnt;
    }

    private void swap(int[] A, int i, int j) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }
}
