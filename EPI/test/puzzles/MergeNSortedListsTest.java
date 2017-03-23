package puzzles;

import com.pholser.junit.quickcheck.ForAll;
import org.junit.contrib.theories.Theories;
import org.junit.contrib.theories.Theory;
import org.junit.runner.RunWith;

import java.util.Collections;
import java.util.List;

/** Created by Pankaj on 7/12/15. */
@RunWith(Theories.class)
public class MergeNSortedListsTest {
  @Theory
  public void checkSorted(@ForAll List<List<Integer>> ls) {
    for (List<Integer> l : ls) {
      Collections.sort(l);
    }
    List<Integer> ans1 = MergeNSortedLists.mergeNSortedLists(ls);
    for (int i = 0; i < ans1.size() - 1; i++) assert (ans1.get(i) <= ans1.get(i + 1));
  }

  @Theory
  public void sameTotalLength(@ForAll List<List<Integer>> ls) {
    for (List<Integer> l : ls) {
      Collections.sort(l);
    }
    int size = MergeNSortedLists.mergeNSortedLists(ls).size();
    int actualSize = 0;
    for (List<Integer> l : ls) {
      actualSize += l.size();
    }
    assert (size == actualSize);
  }

  @Theory
  public void checkWithTrivial(@ForAll List<List<Integer>> ls) {
    for (List<Integer> l : ls) {
      Collections.sort(l);
    }

    List<Integer> ans1 = MergeNSortedLists.mergeNSortedLists(ls);
    List<Integer> ans2 = MergeNSortedLists.mergeNSortedListsTrival(ls);
    assert (ans1.equals(ans2));
  }
}
