import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Pankaj on 7/5/15.
 */
public class MergeNSortedLists {
    public List<Integer> mergeNSortedListsTrival(List<List<Integer>> ls){
        ArrayList<Integer> l = new ArrayList<Integer>();
        for (List<Integer> ll : ls) {
            l.addAll(ll);
        }
        Collections.sort(l);
        return l;
    }
}
