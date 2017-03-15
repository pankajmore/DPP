package stacksAndQueues;

import java.util.ArrayList;
import java.util.Stack;

/**
 * https://www.interviewbit.com/problems/largest-rectangle-in-histogram/ Created by pankaj on
 * 08/03/17.
 */
public class LargestRectangleInHistogram {
  public int largestRectangleArea(ArrayList<Integer> A) {
    int N = A.size(), maxArea = 0;
    Stack<Integer> s = new Stack<>();
    for (int i = 0; i <= N; i++) {
      while (!s.isEmpty() && (i == A.size() || A.get(i) < A.get(s.peek()))) {
        int h = A.get(s.pop());
        maxArea = Math.max(maxArea, h * (i - (s.isEmpty() ? 0 : s.peek() + 1)));
      }
      s.push(i);
    }
    return maxArea;
  }
}
