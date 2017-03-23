package puzzles;

import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/** Created by Pankaj on 12/8/15. */
public class Permutations {

  /**
   * Time: O(n*n!) Space: O(n*n!)
   *
   * @param permutation a starting permutation of integers
   * @return return all the permutations belonging to the same set of integers
   */
  public static List<List<Integer>> allPermutations(List<Integer> permutation) {
    Collections.sort(permutation);
    List<List<Integer>> allPermutations = new ArrayList<>();
    while (permutation != null) {
      allPermutations.add(permutation);
      permutation = nextPermutation(permutation);
    }
    return allPermutations;
  }

  public static void allPermutations(List<Integer> permutation, OutputStream stream) {
    final PrintWriter printWriter = new PrintWriter(stream);
    while (permutation != null) {
      printWriter.println(permutation);
      permutation = nextPermutation(permutation);
    }
  }

  /**
   * Time: O(n) Space: O(n)
   *
   * @param permutation input sequence
   * @return next sequence in the order of permutation rank else null if it is the highest ranked
   *     permutation
   */
  public static List<Integer> nextPermutation(List<Integer> permutation) {
    permutation = new ArrayList<>(permutation);
    int i = inflectionPoint(permutation);
    if (i < 0) return null;
    int j = findReplacementForInflectionPoint(permutation, i);
    assert j != -1;
    swap(permutation, i, j);
    j = permutation.size() - 1;
    i += 1;
    while (i < j) swap(permutation, i++, j--);
    return permutation;
  }

  /**
   * Time : O(N) Space: O(N)
   *
   * @param permutation input sequence of size N
   * @return the prev permutation in the order of permutation rank else null if it is the first
   *     permutation
   */
  public static List<Integer> prevPermutation(List<Integer> permutation) {
    permutation = new ArrayList<>(permutation);
    int i, j, N = permutation.size();
    for (i = N - 2; i >= 0; i--) if (permutation.get(i) > permutation.get(i + 1)) break;
    if (i < 0) return null;
    for (j = N - 1; j >= i; j--) if (permutation.get(j) < permutation.get(i)) break;
    assert j >= i;
    swap(permutation, i, j);
    j = N - 1;
    i += 1;
    while (i < j) swap(permutation, i++, j--);
    return permutation;
  }

  /**
   * Time : O(N * N) (can be improved to NlogN by using order-statistic-trees) Space: O(N)
   *
   * @param permutation input sequence of size N
   * @return the kth permutation sequence
   */
  public static List<Integer> kthPermutation(List<Integer> permutation, int k) {
    List<Integer> sorted = new ArrayList<>(permutation);
    Collections.sort(sorted);
    int N = permutation.size();
    int[] factorial = computeFactorials(N);
    if (k < 0 || k > factorial[N]) throw new IllegalArgumentException("invalid k");
    k--;
    List<Integer> output = new ArrayList<>();
    for (int i = 0; i < N; i++) {
      output.add(searchAndRemove(sorted, k / factorial[N - 1 - i]));
      k %= factorial[N - 1 - i];
    }
    return output;
  }

  private static int searchAndRemove(List<Integer> sorted, int k) {
    int i = 0;
    while (k > 0 || sorted.get(i) == null) {
      if (sorted.get(i) != null) k--;
      i++;
    }
    int elem = sorted.get(i);
    sorted.set(i, null);
    return elem;
  }

  private static int[] computeFactorials(int N) {
    int[] factorial = new int[N + 1];
    factorial[0] = 1;
    for (int i = 1; i <= N; i++) factorial[i] = factorial[i - 1] * i;
    return factorial;
  }

  private static void swap(List<Integer> permutation, int i, int j) {
    Integer temp = permutation.get(i);
    permutation.set(i, permutation.get(j));
    permutation.set(j, temp);
  }

  private static int findReplacementForInflectionPoint(List<Integer> permutation, int i) {
    int j = permutation.size();
    Integer x = permutation.get(i);
    while (--j > i) {
      if (permutation.get(j) > x) return j;
    }
    return -1;
  }

  /**
   * The elements from end should increase and then decrease
   *
   * @param permutation the input permutation
   * @return the index of the first element (from end) which is less than the element after it else
   *     -1 if this is the highest rank permutation.
   */
  private static int inflectionPoint(List<Integer> permutation) {
    int i = permutation.size() - 1;
    while (i > 0) {
      if (permutation.get(i) > permutation.get(i - 1)) return i - 1;
      --i;
    }
    return -1;
  }

  public static List<List<Integer>> allPermutations1(List<Integer> sequence) {
    List<List<Integer>> allPermutations = new ArrayList<>();
    allPermutations1Helper(0, sequence, allPermutations);
    return allPermutations;
  }

  private static void allPermutations1Helper(
      int currentIndex, List<Integer> sequence, List<List<Integer>> allPermutations) {
    if (currentIndex == sequence.size()) {
      allPermutations.add(new ArrayList<>(sequence));
      return;
    }
    for (int j = currentIndex; j < sequence.size(); j++) {
      swap(sequence, currentIndex, j);
      allPermutations1Helper(currentIndex + 1, sequence, allPermutations);
      swap(sequence, j, currentIndex);
    }
  }
}
