package puzzles;

import utils.QueueWithMax;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/** Created by Pankaj on 12/30/15. */
public class SlidingWindow {
  /**
   * Time : O(n) amortised complexity Space : O(w)
   *
   * @param A a list of integers
   * @param w the length of the window
   * @return max in each sliding window
   */
  public static List<Integer> slidingWindowMax(List<Integer> A, int w) {
    List<Integer> output = new ArrayList<>();
    if (A.size() == 0) return output;
    if (w == 0) return A;
    QueueWithMax q = new QueueWithMax();
    /* build the first window fully */
    for (int i = 0; i < w; i++) q.add(A.get(i));
    output.add(q.max());
    for (int i = w; i < A.size(); i++) {
      q.remove();
      q.add(A.get(i));
      output.add(q.max());
    }
    return output;
  }

  public static List<Integer> slidingWindowMax1(List<Integer> A, int w) {
    List<Integer> output = new ArrayList<>();
    if (A.size() == 0) return output;
    if (w == 0) return A;
    Deque<Integer> q = new LinkedList<>();
    int currentMax = A.get(0);
    /* build the 1st sliding window fully */
    for (int i = 0; i < w; i++) {
      currentMax = Math.max(currentMax, A.get(i));
      merge(q, A.get(i));
    }
    output.add(currentMax);
    /* process each sliding window */
    for (int i = w; i < A.size(); i++) {
      int toAdd = A.get(i), toRemove = A.get(i - w);
      merge(q, toAdd);
      currentMax = Math.max(currentMax, toAdd);
      assert toRemove <= q.peekFirst();
      if (currentMax == toRemove) {
        assert toRemove == q.peekFirst();
        q.removeFirst();
        currentMax = q.peekFirst();
      }
      output.add(currentMax);
    }
    return output;
  }

  public static List<Integer> slidingWindowMax2(List<Integer> A, int w) {
    List<Integer> output = new ArrayList<>();
    if (A.size() == 0) return output;
    if (w == 0) return A;
    for (int i = w; i <= A.size(); i++) {
      int currentMax = A.get(i - w);
      for (int j = i - w; j < i; j++) currentMax = Math.max(currentMax, A.get(j));
      output.add(currentMax);
    }
    return output;
  }

  private static void merge(Deque<Integer> q, int x) {
    while (!q.isEmpty() && q.peekLast() < x) q.removeLast();
    q.addLast(x);
  }
}
