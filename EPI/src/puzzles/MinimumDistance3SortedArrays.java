package puzzles;

import java.util.*;

/**
 * Created by pankaj on 2/25/16.
 */
public class MinimumDistance3SortedArrays {
    /**
     * Return the minDistance = Min(|A[i] - B[j]|, |B[j] - C[k]|, |C[k] - A[i]|) for all i,j,k
     * <p>
     * Time : O(N_A + N_B + N_C)
     * Space: O(1)
     *
     * @param A list of size N_A
     * @param B list of size N_B
     * @param C list of size N_C
     * @return the minDistance as defined above
     */
    public static int minimumDistance(List<Integer> A, List<Integer> B, List<Integer> C) {
        int i = 0, j = 0, k = 0;
        int minDistance = Integer.MAX_VALUE;
        while (i < A.size() || j < B.size() || k < C.size()) {
            minDistance = Math.min(minDistance, Math.max(Math.abs(A.get(i) - B.get(j)),
                    Math.max(Math.abs(B.get(j) - C.get(k)), Math.abs(C.get(k) - A.get(i)))));
            int min = Math.min(A.get(i), Math.min(B.get(j), C.get(k)));
            if (i < A.size() && min == A.get(i)) i++;
            else if (j < B.size() && min == B.get(j)) j++;
            else k++;
        }
        return minDistance;
    }

    /**
     * Time : O(NlogK)
     * Space: O(k)
     *
     * @param A list of K lists of integers. total number of elements = N
     * @return the minimumDistance between any k elements, one from each list
     */
    public static int minimumDistance(List<List<Integer>> A) {
        int minDistance = Integer.MAX_VALUE;
        SortedMap<Integer, Queue<Iterator<Integer>>> map = new TreeMap<>();
        for (int i = 0; i < A.size(); i++) {
            Iterator<Integer> it = A.get(i).iterator();
            if (!it.hasNext()) return minDistance;
            Integer k = it.next();
            if (!map.containsKey(k)) map.put(k, new LinkedList<>());
            map.get(k).add(it);
        }
        while (!map.isEmpty()) {
            minDistance = Math.min(minDistance, map.lastKey() - map.firstKey());
            Integer min = map.firstKey();
            Iterator<Integer> it = map.get(min).remove();
            if (map.get(min).isEmpty()) map.remove(min);
            if (!it.hasNext()) return minDistance;
            Integer k = it.next();
            if (!map.containsKey(k)) map.put(k, new LinkedList<>());
            map.get(k).add(it);

        }
        return minDistance;
    }
}
