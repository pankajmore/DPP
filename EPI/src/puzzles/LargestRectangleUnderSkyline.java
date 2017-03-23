package puzzles;

import java.util.List;
import java.util.Stack;

/** Created by Pankaj on 12/16/15. */
public class LargestRectangleUnderSkyline {
  /**
   * Time : O(n) Space : O(n)
   *
   * @param A the list of heights of each building of unit width
   * @return the largest rectangle under the skyline
   */
  public static int calculateLargestRectangle(List<Integer> A) {
    int maxArea = 0;
    Stack<Integer> s = new Stack<>();
    for (int i = 0; i <= A.size(); i++) {
      while (!s.isEmpty() && (i == A.size() || A.get(i) < A.get(s.peek()))) {
        int height = A.get(s.pop());
        maxArea = Math.max(maxArea, height * (s.isEmpty() ? i : i - s.peek() - 1));
      }
      s.push(i);
    }
    return maxArea;
  }
}
