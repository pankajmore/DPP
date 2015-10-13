package puzzles;

import java.util.PriorityQueue;

/**
 * Created by Pankaj on 10/13/15.
 */
public class ApproximateSort {
    public static int[] sortApproximatelySortedData(int[] A, int k) throws Exception {
        if (k < 0 || k > A.length) throw new Exception("Invalid K");
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int i = 0; i < k; i++) minHeap.add(A[i]);
        for (int i = k; i < A.length; i++) {
            minHeap.add(A[i]);
            A[i - k] = minHeap.poll();
        }
        for (int i = A.length - k; i < A.length; i++) A[i] = minHeap.poll();
        assert minHeap.isEmpty();
        return A;
    }
}
