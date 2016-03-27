public class ZigZag {

    public int longestZigZag(int[] sequence) {
        int N = sequence.length;
        int[] A = new int[N], B = new int[N];
        A[0] = B[0] = 1;
        for (int i = 1; i < N; i++) {
            A[i] = B[i] = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (sequence[i] > sequence[j]) {
                    A[i] = Math.max(A[i], B[j] + 1);
                } else if (sequence[i] < sequence[j]) {
                    B[i] = Math.max(B[i], A[j] + 1);
                }
            }
        }
        return Math.max(A[N - 1], B[N - 1]);
    }
}
