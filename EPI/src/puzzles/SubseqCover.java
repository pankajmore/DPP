package puzzles;

import java.io.InputStream;
import java.util.*;
import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * Created by Pankaj on 11/30/15.
 */
public class SubseqCover {
    /**
     * Assumes that keywords are distinct
     *
     * @param paragraph
     * @param keywords
     * @return
     */
    public static SubArray findSmallestSequentiallyCoveringSubset(List<String> paragraph, List<String> keywords) {
        int i = 0, j = 0, N = paragraph.size(), M = keywords.size();
        SubArray minimalSubArray = new SubArray(0, N - 1);
        Set<String> keywordSet = new HashSet<>(keywords);
        Map<String, Integer> map = new HashMap<>();
        while (j < N) {
            while (j < N && map.size() < M) {
                String keyword = paragraph.get(j);
                if (keywordSet.contains(keyword)) {
                    if (!map.containsKey(keyword)) map.put(keyword, 0);
                    map.put(keyword, map.get(keyword) + 1);
                }
                ++j;
            }
            if (map.size() == M) {
                SubArray subArray = new SubArray(i, j - 1);
                if (subArray.compareTo(minimalSubArray) < 0) minimalSubArray = subArray;
            }
            while (i < j && map.size() == M) {
                SubArray subArray = new SubArray(i, j - 1);
                if (subArray.compareTo(minimalSubArray) < 0) minimalSubArray = subArray;
                String keyword = paragraph.get(i);
                if (keywordSet.contains(keyword)) {
                    map.put(keyword, map.get(keyword) - 1);
                    if (map.get(keyword) == 0) map.remove(keyword);
                }
                ++i;
            }
        }
        return minimalSubArray;
    }

    public static SubArray findSmallestSequentiallyCoveringSubset(InputStream paragraph, List<String> keywords) {
        Deque<Integer> lastOccurrence = new ConcurrentLinkedDeque<>();
        Map<String, Iterator<Integer>> map = new HashMap<>();
        Set<String> keywordSet = new HashSet<>(keywords);
        Scanner in = new Scanner(paragraph);
        SubArray bestSubArray = null;
        int i = 0;
        while (in.hasNext()) {
            String s = in.next();
            if (keywordSet.contains(s)) {
                if (map.containsKey(s)) {
                    map.get(s).next(); // needed to make remove() not throw IllegalStateException
                    map.get(s).remove();
                }
                lastOccurrence.add(i);
                map.put(s, lastOccurrence.descendingIterator());
            }
            if (map.size() == keywordSet.size()) {
                SubArray currSubArray = new SubArray(lastOccurrence.getFirst(), i);
                if (bestSubArray == null || currSubArray.compareTo(bestSubArray) < 0) bestSubArray = currSubArray;
            }
            ++i;
        }
        return bestSubArray;
    }

    public static class SubArray implements Comparable<SubArray> {
        public final Integer start;
        public final Integer end;

        public SubArray(Integer start, Integer end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(SubArray o) {
            if (this.end - this.start < o.end - o.start) return -1;
            if (this.end - this.start == o.end - o.start) return this.start.compareTo(o.start);
            else return 1;
        }
    }
}
