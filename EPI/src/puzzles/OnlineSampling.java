package puzzles;

import java.util.*;

/**
 * Created by Pankaj on 12/24/15.
 */
public class OnlineSampling {
    /**
     * Time : O(k)
     * Space : O(1)
     *
     * @param n positive integer
     * @param k 0 <= k <= n, k is an integer
     * @return a uniformly random subset of [0..n-1] and size k
     */
    public static List<Integer> randomSubset(int n, int k) {
        List<Integer> subset = new ArrayList<>();
        Map<Integer, Integer> m = new HashMap<>();
        Random rand = new Random();
        for (int i = 0; i < k; i++) {
            int x = i + rand.nextInt(n - i); /* uniformly random in [i,n) */
            Integer m_x = m.get(x), m_i = m.get(i);
            if (m_x == null && m_i == null) {
                m.put(x, i);
                m.put(i, x);
            } else if (m_x != null && m_i == null) /* A[i] = i and A[x] != x */ {
                m.put(i, m_x);
                m.put(x, i);
            } else if (m_x == null) {
                m.put(i, x);
                m.put(x, m_i);
            } else {
                m.put(i, m_x);
                m.put(x, m_i);
            }
        }
        for (int i = 0; i < k; i++) subset.add(m.get(i));
        return subset;
    }

    /**
     * Time : O(k)
     * Space : O(1)
     * TODO: check the correctness
     *
     * @param n positive integer
     * @param k 0 <= k <= n, k is an integer
     * @return a uniformly random subset of [0..n-1] and size k
     */
    public static List<Integer> randomSubset1(int n, int k) {
        List<Integer> subset = new ArrayList<>();
        Map<Integer, Integer> m = new HashMap<>();
        Random gen = new Random();
        for (int i = 0; i < k; i++) {
            int x = i + gen.nextInt(n - i); /* uniformly random in [i,n-1] */
            subset.add(m.containsKey(x) ? m.get(x) : x);
            m.put(x, i); /* swap A[i] with A[x], we don't need to update A[i] */
        }
        return subset;
    }
}
