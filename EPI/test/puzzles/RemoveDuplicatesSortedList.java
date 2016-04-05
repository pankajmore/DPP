package puzzles;

import java.util.List;

/**
 * Created by Pankaj on 11/21/15.
 */
public class RemoveDuplicatesSortedList {
    public static int removeDuplicates(List<Integer> l) {
        int j = 0;
        for (int i = 1; i < l.size(); i++)
            if (!l.get(j).equals(l.get(i))) l.set(++j, l.get(i));
        return ++j;
    }

    /**
     * @param l sorted
     * @return return the length of the new list, at most 2 duplicates allowed
     */
    public static int removeDuplicatesKeepAtMostTwo(List<Integer> l) {
        int i = 0;
        for (int n : l) {
            if (i < 2 || n > l.get(i - 2))
                l.set(i++, n);
        }
        return i;
    }
}
