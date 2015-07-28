package puzzles;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pankaj on 7/28/15.
 */
public class MergeTwoSortedArraysInPlace {
    public static <T extends Comparable<T>> List<T> merge(List<T> l1, List<T> l2) {
        ArrayList<T> mergedList = new ArrayList<>();
        int i = 0, j = 0, k = 0;
        while (i < l1.size() && j < l2.size()) {
            if (l1.get(i).compareTo(l2.get(j)) <= 0)
                mergedList.add(l1.get(i++));
            else mergedList.add(l2.get(j++));
        }
        while (i < l1.size()) mergedList.add(l1.get(i++));
        while (j < l2.size()) mergedList.add(l2.get(j++));
        return mergedList;
    }

    public static <T extends Comparable<T>> List<T> mergeInPlace(List<T> l1, List<T> l2) {
        int m = l1.size(), n = l2.size();
        l1.addAll(l2);//expand to be able to store everything.
        for (int i = m - 1; i >= 0; i--) l1.set(i + n, l1.get(i)); //shift l1 to end
        int i = n, j = 0, k = 0;
        while (i < m + n && j < n) {
            if (l1.get(i).compareTo(l2.get(j)) <= 0) {
                l1.set(k++, l1.get(i++));
            } else {
                l1.set(k++, l2.get(j++));
            }
        }
        while (i < m + n) l1.set(k++, l1.get(i++));
        while (j < n) l1.set(k++, l2.get(j++));
        return l1;
    }
}
