package puzzles;

import java.util.*;

/**
 * Created by pankaj on 3/1/16.
 */
public class KMostFrequentQueries {
    /**
     * Time : O(N + MLogK)
     * Space: O(M)
     *
     * @param list list of N strings (M distinct)
     * @param k    the number of most frequent strings to return
     * @return the list of top k strings by count
     */
    public List<String> topK(List<String> list, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String s : list) {
            if (!map.containsKey(s))
                map.put(s, 0);
            map.put(s, map.get(s) + 1);
        }
        return topKFromMap(map, k);
    }

    private List<String> topKFromMap(Map<String, Integer> map, int k) {
        List<String> list = new ArrayList<>();
        Queue<DataWithCount<String>> q = new PriorityQueue<>();
        for (String s : map.keySet()) {
            DataWithCount<String> stringData = new DataWithCount<>(map.get(s), s);
            if (q.size() < k) q.add(stringData);
            else if (q.peek().compareTo(stringData) < 0) {
                q.remove();
                q.add(stringData);
            }
        }
        while (!q.isEmpty()) {
            list.add(q.remove().data);
        }
        Collections.reverse(list);
        return list;
    }

    private static class DataWithCount<T> implements Comparable<DataWithCount<T>> {
        public int count;
        public T data;

        public DataWithCount(int count, T data) {
            this.count = count;
            this.data = data;
        }

        @Override
        public int compareTo(DataWithCount<T> o) {
            return Integer.compare(this.count, o.count);
        }
    }
}
