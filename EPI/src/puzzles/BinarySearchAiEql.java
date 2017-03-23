package puzzles;

import java.util.List;

/** Created by pankaj on 3/6/16. */
public class BinarySearchAiEql {
  /**
   * Time : O(logN) Space: O(1)
   *
   * @param A a list of N distinct integers
   * @return an index i such that A[i] = i , else -1
   */
  public static int searchEntryEqualToItsIndex(List<Integer> A) {
    int low = 0, high = A.size() - 1;
    while (low <= high) {
      int mid = (low + high) / 2;
      if (A.get(mid) == mid) return mid;
      else if (A.get(mid) < mid) low = mid + 1;
      else high = mid - 1;
    }
    return -1;
  }
}
