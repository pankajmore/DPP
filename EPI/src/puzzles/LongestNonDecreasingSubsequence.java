package puzzles;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/** Created by pankaj on 1/19/16. Find longest non-decreasing subsequents */
class LongestNonDecreasingSubsequence {
  /**
   * Time : O(N^2) Space : O(N)
   *
   * @param sequence a list of N integers
   * @return a non-decreasing subsequent of largest size
   */
  static List<Integer> longestNonDecreasingSubSequence(List<Integer> sequence) {
    if (sequence.size() == 0) return sequence;
    int N = sequence.size();
    int[] sequenceSize = new int[N], prev = new int[N];
    sequenceSize[0] = 1;
    prev[0] = -1;
    for (int i = 1; i < N; i++) {
      sequenceSize[i] = 1;
      prev[i] = -1;
      for (int j = 0; j < i; j++) {
        if (sequence.get(j) <= sequence.get(i)) {
          if (sequenceSize[j] + 1 >= sequenceSize[i]) {
            sequenceSize[i] = sequenceSize[j] + 1;
            prev[i] = j;
          }
        }
      }
    }
    int longestSequenceEndpoint = 0, longestSequenceSize = 1;
    for (int i = 1; i < N; i++) {
      if (sequenceSize[i] >= longestSequenceSize) {
        longestSequenceSize = sequenceSize[i];
        longestSequenceEndpoint = i;
      }
    }
    int j = longestSequenceEndpoint;
    List<Integer> longestNonDecreasingSubsequence = new ArrayList<>();
    while (j != -1) {
      longestNonDecreasingSubsequence.add(sequence.get(j));
      j = prev[j];
    }
    assert longestNonDecreasingSubsequence.size() == longestSequenceSize;
    Collections.reverse(longestNonDecreasingSubsequence);
    return longestNonDecreasingSubsequence;
  }

  /**
   * Time : O(Nlog(N)) Space : O(N)
   *
   * @param sequence a list of N integers
   * @return size of the largest non-decreasing subsequent
   */
  public static int longestNonDecreasingSubSequenceLength(List<Integer> sequence) {
    if (sequence.size() == 0) return 0;
    int N = sequence.size();
    List<Integer> subsequence = new ArrayList<>();
    for (int i = 0; i < N; i++) {
      int val = sequence.get(i);
      int index = Collections.binarySearch(subsequence, val, new UpperBoundComparator());
      assert index < 0;
      int pos = -index - 1;
      if (pos < subsequence.size()) subsequence.set(pos, val);
      else {
        assert pos == subsequence.size();
        subsequence.add(val);
      }
    }
    return subsequence.size();
  }

  /**
   * Time : O(Nlog(N)) Space : O(N)
   *
   * @param sequence a list of N integers
   * @return size of the largest non-decreasing subsequent
   */
  public static List<Integer> longestNonDecreasingSubSequenceEfficient(List<Integer> sequence) {
    if (sequence.size() == 0) return sequence;
    int N = sequence.size();
    int[] prev = new int[N];
    List<Integer> subsequence = new ArrayList<>();
    for (int i = 0; i < N; i++) {
      int val = sequence.get(i);
      int pos = binarySearch(subsequence, sequence, val);
      if (pos < subsequence.size()) {
        subsequence.set(pos, i);
      } else {
        assert pos == subsequence.size();
        subsequence.add(i);
      }
      prev[i] = pos == 0 ? -1 : subsequence.get(pos - 1);
    }
    List<Integer> longestSubsequence = new ArrayList<>();
    int lastIdx = subsequence.get(subsequence.size() - 1);
    while (lastIdx != -1) {
      longestSubsequence.add(sequence.get(lastIdx));
      lastIdx = prev[lastIdx];
    }
    Collections.reverse(longestSubsequence);
    return longestSubsequence;
  }

  /**
   * @param idx
   * @param x
   * @return pos s.t A[pos] > x and forall i < pos A[i] <= x
   */
  private static int binarySearch(List<Integer> idx, List<Integer> A, int x) {
    int lo = 0, hi = idx.size();
    while (lo < hi) {
      int mid = lo + (hi - lo) / 2;
      if (A.get(idx.get(mid)) <= x) lo = mid + 1;
      else hi = mid;
    }
    return hi;
  }

  private static class UpperBoundComparator implements Comparator<Integer> {
    @Override
    public int compare(Integer x, Integer y) {
      if (x.equals(y)) return -1;
      return Integer.compare(x, y);
    }
  }
}
