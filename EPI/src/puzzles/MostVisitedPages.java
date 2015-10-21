package puzzles;

import java.util.*;

/**
 * Created by Pankaj on 10/21/15.
 */
public class MostVisitedPages {
    private TreeMap<Key, Integer> _map = new TreeMap<>(new EntryComparator());

    /**
     * Time : O(log(n)), n = number of distinct pages
     *
     * @param p adds the given log entry
     */
    public void add(Entry p) {
        if (!_map.containsKey(p.toKey(0))) {
            _map.put(p.toKey(0), 0);
        }
        Integer count = _map.get(p.toKey(0));
        _map.remove(p.toKey(0));
        _map.put(p.toKey(++count), count);
    }


    /**
     * Time : O(k*log(n)), n = number of distinct pages
     *
     * @param k most visited pages
     * @return list of top k most visited pages
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
            return Integer.compare(this._count, o._count);
        }
    }

    private static class EntryComparator implements Comparator<Key> {

        @Override
        public int compare(Key o1, Key o2) {
            return o1._page.compareTo(o2._page);
        }
    }
}
