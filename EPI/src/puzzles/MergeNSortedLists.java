package puzzles;

import utils.Pair;

import java.util.*;

/** Created by Pankaj on 7/5/15. */
public class MergeNSortedLists {
  public static List<Integer> mergeNSortedLists(List<List<Integer>> ls) {
    List<Integer> ans = new ArrayList<Integer>();
    List<Integer> heads = new ArrayList<Integer>();
    PriorityQueue<Pair<Integer, Integer>> q =
        new PriorityQueue<Pair<Integer, Integer>>(
            11,
            new Comparator<Pair<Integer, Integer>>() {
              @Override
              public int compare(Pair<Integer, Integer> p1, Pair<Integer, Integer> p2) {
                return p1.first().compareTo(p2.first());
              }
            });

    // add the heads of each list into the queue
    for (int i = 0; i < ls.size(); i++) {
      List<Integer> l = ls.get(i);
      if (l.size() > 0) {
        q.add(new Pair<Integer, Integer>(l.get(0), i));
        heads.add(1);
      } else heads.add(0);
    }
    assert (heads.size() == ls.size());

    while (!q.isEmpty()) {
      ans.add(q.peek().first());
      List<Integer> smallestList = ls.get(q.peek().second());
      Integer smallestHead = heads.get(q.peek().second());
      if (smallestHead < smallestList.size()) {
        q.add(new Pair<Integer, Integer>(smallestList.get(smallestHead), q.peek().second()));
        heads.set(q.peek().second(), heads.get(q.peek().second()) + 1);
      }
      q.remove();
    }

    return ans;
  }

  public static List<Integer> mergeNSortedListsTrival(List<List<Integer>> ls) {
    ArrayList<Integer> l = new ArrayList<Integer>();
    for (List<Integer> ll : ls) {
      l.addAll(ll);
    }
    Collections.sort(l);
    return l;
  }
}
