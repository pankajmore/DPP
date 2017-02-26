import java.util.*;

/**
 * https://leetcode.com/problems/top-k-frequent-elements/
 * Created by pankaj on 26/02/17.
 */
public class TopKFrequentElements {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int x : nums) map.put(x, map.getOrDefault(x, 0) + 1);
        PriorityQueue<Entry> q = new PriorityQueue<>();
        for (int x : map.keySet()) {
            Entry e = new Entry(x, map.get(x));
            if (q.size() < k) {
                q.add(e);
            } else if (q.peek().compareTo(e) < 0) {
                q.remove();
                q.add(e);
            }
        }
        List<Integer> res = new ArrayList<>();
        while (!q.isEmpty()) res.add(q.remove().element);
        Collections.reverse(res);
        return res;
    }

    public static class Entry implements Comparable<Entry> {
        int element, freq;

        Entry(int element, int freq) {
            this.element = element;
            this.freq = freq;
        }

        @Override
        public int compareTo(Entry e) {
            if (this.freq != e.freq)
                return this.freq - e.freq;
            else return this.element - e.element;
        }
    }
}
