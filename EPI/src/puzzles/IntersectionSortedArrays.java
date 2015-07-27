package puzzles;

import java.util.*;

/**
 * Created by Pankaj on 7/27/15.
 */
public class IntersectionSortedArrays {
    /**
     * Computes the intersection of 2 sorted arrays ( s1.size() << s2.size )
     *
     * @param s1  sorted array of small size
     * @param s2  sorted array of very large size
     * @param <T> type of elements in both arrays
     * @return intersection of s1 and s2 with duplicates removed
     */
    public static <T extends Comparable<T>> List<T> intersect1(List<T> s1, List<T> s2) {
        List<T> si = new ArrayList<>();
        for (int i = 0; i < s1.size(); i++) {
            T e = s1.get(i);
            if (Collections.binarySearch(s2, e) >= 0 && (i == 0 || s1.get(i) != s1.get(i - 1)))
                si.add(e);
        }
        return si;
    }

    /**
     * Computes the intersection of 2 sorted arrays ( s1.size() ~ s2.size )
     *
     * @param s1  sorted array
     * @param s2  sorted array of similar size
     * @param <T> type of elements in both arrays
     * @return intersection of s1 and s2 with duplicates removed
     */
    public static <T extends Comparable<T>> List<T> intersect2(List<T> s1, List<T> s2) {
        List<T> si = new ArrayList<>();
        int i = 0, j = 0;
        while (i < s1.size() && j < s2.size()) {
            if (s1.get(i).compareTo(s2.get(j)) == 0 && (i == 0 || s1.get(i) != s1.get(i - 1))) {
                si.add(s1.get(i));
                i++;
                j--;
            } else if (s1.get(i).compareTo(s2.get(j)) < 0)
                i++;
            else j++;
        }
        return si;
    }

    /**
     * Computes the intersection of 2 sorted arrays using built in set methods
     *
     * @param s1  sorted array
     * @param s2  sorted array
     * @param <T> type of elements in both arrays
     * @return intersection of s1 and s2 with duplicates removed
     */
    public static <T extends Comparable<T>> List<T> intersectTrivial(List<T> s1, List<T> s2) {
        Set<T> ss1 = new HashSet<>(s1);
        Set<T> ss2 = new HashSet<>(s2);
        ss1.retainAll(ss2);
        return new ArrayList<>(ss1);
    }
}
