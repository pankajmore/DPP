package puzzles;

import com.pholser.junit.quickcheck.ForAll;
import org.junit.contrib.theories.Theories;
import org.junit.contrib.theories.Theory;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

@RunWith(Theories.class)
public class KthLargestElementTest {
  @Theory
  public void partitionPivotRankTheory(@ForAll List<Integer> l) {
    l = new ArrayList<>(new HashSet<>(l)); //uniqify
    ArrayList<Integer> sortedl = new ArrayList<>(l);
    Collections.sort(sortedl, Collections.reverseOrder());
    for (int k = 0; k < l.size(); k++) {
      int pivot = l.get(k);
      int actualRank = KthLargestElement.partitionPivotRank(l, k);
      int pivotRank = l.indexOf(pivot);
      int expectedRank = sortedl.indexOf(pivot);
      assert (expectedRank == actualRank);
      assert (actualRank == pivotRank);
      for (int i = 0; i < pivotRank; i++) assert (l.get(i) > pivot);
      for (int i = pivotRank + 1; i < l.size(); i++) assert (l.get(i) < pivot);
    }
  }

  @Theory
  public void usingPartitionTheory(@ForAll List<Integer> l) {
    //Elements in l need to be distinct
    l = new ArrayList<>(new HashSet<>(l));
    Collections.unmodifiableList(l);
    ArrayList<Integer> ls = new ArrayList<>(l);
    //Collections.copy(l1,l);
    for (int k = 0; k < l.size(); k++) {
      Integer expected = KthLargestElement.usingSort(l, k);
      Integer actualI = KthLargestElement.usingPartitionIterative(l, k);
      Integer actualR = KthLargestElement.usingPartitionRecursive(ls, k);
      assert (actualI.equals(expected));
      assert (actualR.equals(expected));
    }
  }
}
