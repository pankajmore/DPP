package puzzles;

import java.util.Collections;
import java.util.List;
import java.util.Random;

/** Created by Pankaj on 7/21/15. */
public class KthLargestElement {
  /**
   * finds kth largest element using quicksort's partition function as a subroutine
   *
   * @param l
   * @param <T>
   * @return
   */
  public static <T extends Comparable<T>> T usingPartitionRecursive(List<T> l, int k) {
    int pivotIndex = new Random().nextInt(l.size());
    T pivot = l.get(pivotIndex);
    int i = partitionPivotRank(l, pivotIndex);
    if (k == i) return pivot;
    else if (k < i) return usingPartitionRecursive(l.subList(0, i), k);
    else return usingPartitionRecursive(l.subList(i + 1, l.size()), k - (i + 1));
  }

  public static <T extends Comparable<T>> T usingPartitionIterative(List<T> l, int k) {
    int pivotIndex = new Random().nextInt(l.size());
    T pivot = l.get(pivotIndex);
    int i = partitionPivotRank(l, pivotIndex);
    while (k != i) {
      if (k < i) {
        l = l.subList(0, i);
      } else {
        l = l.subList(i + 1, l.size());
        k -= i + 1;
      }
      pivotIndex = new Random().nextInt(l.size());
      pivot = l.get(pivotIndex);
      i = partitionPivotRank(l, pivotIndex);
    }
    return pivot;
  }

  public static <T extends Comparable<T>> int partitionPivotRank(List<T> l, int pivotIndex) {
    T pivot = l.get(pivotIndex);
    Collections.swap(l, 0, pivotIndex); // bring pivot to 0
    if (l.size() == 1) return 0;
    int i = 1, j = l.size() - 1;
    while (i < j) {
      if (l.get(i).compareTo(pivot) < 0 && l.get(j).compareTo(pivot) > 0) {
        Collections.swap(l, i, j);
      }
      if (l.get(i).compareTo(pivot) > 0) i++;
      if (l.get(j).compareTo(pivot) < 0) j--;
    }
    if (l.get(i).compareTo(pivot) > 0) {
      Collections.swap(l, i, 0);
      return i;
    } else {
      Collections.swap(l, i - 1, 0);
      return i - 1;
    }
  }

  public static <T extends Comparable<T>> T usingSort(List<T> l, int k) {
    Collections.sort(l, Collections.reverseOrder());
    return l.get(k);
  }

  /**
   * finds kth largest element using median finding algorithm as a subroutine
   *
   * @param l
   * @param <T>
   * @return
   */
  //TODO
  public <T extends Comparable<T>> T usingMedians(List<T> l, int k) {
    return null;
  }

  /**
   * Find median of a list in linear time
   *
   * @param l
   * @param <T>
   * @return
   */
  //TODO
  private <T extends Comparable<T>> T findMedian(List<T> l) {
    return null;
  }
}
