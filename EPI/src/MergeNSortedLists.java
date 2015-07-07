import java.util.*;

/**
 * Created by Pankaj on 7/5/15.
 */
public class MergeNSortedLists {
    public List<Integer> mergeNSortedLists(List<List<Integer>> ls){
        ArrayList<Iterator<Integer>> iterators = new ArrayList<Iterator<Integer>>();
        for (List<Integer> l : ls) {
            iterators.add(l.iterator());
        }

        ArrayList<Integer> ans = new ArrayList<Integer>();
        PriorityQueue<Integer> q = new PriorityQueue<Integer>();
        for (Iterator<Integer> iter : iterators) {
            if(iter.hasNext())
                q.add(iter.next());
        }

        while(!q.isEmpty()){
            ans.add(q.poll());
            for (Iterator<Integer> iter : iterators) {
                if (iter.hasNext())
                {
                    q.add(iter.next());
                break;
            }
            }
        }
        //TODO: complete this
        return ans;
    }

    public List<Integer> mergeNSortedListsTrival(List<List<Integer>> ls){
        ArrayList<Integer> l = new ArrayList<Integer>();
        for (List<Integer> ll : ls) {
            l.addAll(ll);
        }
        Collections.sort(l);
        return l;
    }
}
