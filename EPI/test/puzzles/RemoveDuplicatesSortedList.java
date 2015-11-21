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
}
