package puzzles;

import java.util.*;

/**
 * Created by Pankaj on 10/21/15.
 */
public class MostVisitedPages {
    private Map<String, Integer> _hash = new HashMap<>();
    private TreeMap<Key, Integer> _map = new TreeMap<>();

    private Key getKey(String page) {
        return new Key(page, _hash.get(page));
    }

    /**
     * Time : O(log(n)), n = number of distinct pages
     *
     * @param p adds the given log entry
     */
    public void add(Entry p) {
        if (!_hash.containsKey(p._page)) _hash.put(p._page, 0);
        if (!_map.containsKey(getKey(p._page))) _map.put(getKey(p._page), 0);
        _map.remove(getKey(p._page));
        _hash.put(p._page, _hash.get(p._page) + 1);
        _map.put(getKey(p._page), _hash.get(p._page));
    }


    /**
     * Time : O(k+log(n)), n = number of distinct pages
     *
     * @param k most visited pages
     * @return list of top min(k,n) most visited pages
     */
    public List<String> common(int k) {
        ArrayList<String> topKPages = new ArrayList<>();
        Iterator<Key> keyIterator = _map.descendingKeySet().iterator();
        while (keyIterator.hasNext() && k-- > 0)
            topKPages.add(keyIterator.next()._page);
        return topKPages;
    }

    public static class Entry {
        private final String _page;
        private final Integer _timestamp;

        public Entry(String page, Integer timestamp) {
            _page = page;
            _timestamp = timestamp;
        }

        public Key toKey(Integer count) {
            return new Key(_page, count);
        }
    }

    public static class Key implements Comparable<Key> {
        private final String _page;
        private final Integer _count;

        public Key(String page, Integer count) {
            _page = page;
            _count = count;
        }

        @Override
        public int compareTo(Key o) {
            int i = Integer.compare(this._count, o._count);
            if (i != 0) return i;
            // if count is same, the smaller page is "more frequent" than larger page.
            return -this._page.compareTo(o._page);
        }
    }
}
