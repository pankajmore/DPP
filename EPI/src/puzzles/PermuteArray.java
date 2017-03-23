package puzzles;

import java.util.ArrayList;
import java.util.List;

/** Created by Pankaj on 12/23/15. */
public class PermuteArray {
  /**
   * Permute the elements of A by applying the permutation sequence perm Time: O(n) Space: O(1)
   *
   * @param A the input list to permute
   * @param perm the permutation sequence to use
   */
  public static void permute(List<Integer> A, List<Integer> perm) {
    int N = A.size();
    for (int i = 0; i < N; i++)
      if (perm.get(i) >= 0 /* not visited */) cyclePermutation(A, perm, i);
    for (int i = 0; i < N; i++)
      perm.set(i, perm.get(i) + N); /* reset permutation list to its original values */
  }

  private static void cyclePermutation(List<Integer> A, List<Integer> perm, int i) {
    int start = i, curr = A.get(i), next, nextI, N = A.size();
    do {
      next = A.get(perm.get(i));
      A.set(perm.get(i), curr);
      curr = next;
      nextI = perm.get(i);
      perm.set(i, perm.get(i) - N);
      i = nextI;
    } while (i != start);
  }

  /**
   * Permute the elements of A by applying the permutation sequence perm Time: O(n) Space: O(n)
   *
   * @param A the input list to permute
   * @param perm the permutation sequence to use
   */
  public static List<Integer> permute1(List<Integer> A, List<Integer> perm) {
    List<Integer> B = new ArrayList<>();
    for (int i = 0; i < A.size(); i++) B.add(0);
    for (int i = 0; i < A.size(); i++) B.set(perm.get(i), A.get(i));
    return B;
  }
}
