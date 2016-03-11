package puzzles;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by pankaj on 3/11/16.
 */
public class KLargestElementsBinaryHeap {
    /**
     * Time : O(KLogK)
     * Space: O(K)
     *
     * @param A a heap of N integers stored as an array list
     * @param k the number of largest integers to get
     * @return a list of k largest integers in A
     */
    public static List<Integer> kLargestInBinaryHeap(List<Integer> A, int k) {
        int N = A.size();
        List<Integer> kLargest = new ArrayList<>();
        if (N == 0) return kLargest;
        PriorityQueue<ArrayData> q = new PriorityQueue<>(Comparator.reverseOrder());
        q.add(new ArrayData(A.get(0), 0));
        while (!q.isEmpty() && kLargest.size() < k) {
            ArrayData data = q.remove();
            kLargest.add(data.val);
            int idx = data.idx << 1;
            if (++idx < N) q.add(new ArrayData(A.get(idx), idx));
            if (++idx < N) q.add(new ArrayData(A.get(idx), idx));
        }
        return kLargest;
    }

    private static class ArrayData implements Comparable<ArrayData> {
        public int val, idx;

        public ArrayData(int val, int idx) {
            this.val = val;
            this.idx = idx;
        }

        @Override
        public int compareTo(ArrayData o) {
            return Integer.compare(this.val, o.val);
        }
    }
}
