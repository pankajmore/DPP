package puzzles;

import com.pholser.junit.quickcheck.ForAll;
import org.junit.contrib.theories.Theories;
import org.junit.contrib.theories.Theory;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/** Created by Pankaj on 7/28/15. */
@RunWith(Theories.class)
public class MergeTwoSortedArraysInPlaceTest {
  @Theory
  public void compareWithTrivial(@ForAll List<Integer> l1, @ForAll List<Integer> l2) {
    Collections.sort(l1);
    Collections.sort(l2);
    List<Integer> mergeTrivial = mergeTrivial(l1, l2);
    List<Integer> merge = MergeTwoSortedArraysInPlace.merge(l1, l2);
    List<Integer> mergeInPlace = MergeTwoSortedArraysInPlace.mergeInPlace(l1, l2);
    assert mergeInPlace.equals(mergeTrivial);
    assert mergeInPlace.equals(merge);
  }

  private <T extends Comparable<T>> List<T> mergeTrivial(List<T> l1, List<T> l2) {
    ArrayList<T> ts = new ArrayList<>();
    ts.addAll(l1);
    ts.addAll(l2);
    Collections.sort(ts);
    return ts;
  }
}
