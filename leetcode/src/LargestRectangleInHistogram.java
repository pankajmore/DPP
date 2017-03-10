import java.util.Stack;

/** https://leetcode.com/problems/largest-rectangle-in-histogram/ Created by pankaj on 10/03/17. */
public class LargestRectangleInHistogram {
  public int largestRectangleArea(int[] heights) {
    int N = heights.length, maxArea = 0;
    int[] right = new int[N];
    Stack<Integer> s = new Stack<>();
    for (int i = N - 1; i >= 0; i--) {
      while (!s.isEmpty() && heights[i] <= heights[s.peek()]) {
        s.pop();
      }
      right[i] = s.isEmpty() ? N - 1 : s.peek() - 1;
      s.push(i);
    }
    int left = 0;
    s.clear();
    for (int i = 0; i < N; i++) {
      while (!s.isEmpty() && heights[i] <= heights[s.peek()]) {
        s.pop();
      }
      left = s.isEmpty() ? 0 : s.peek() + 1;
      s.push(i);
      maxArea = Math.max(maxArea, (right[i] - left + 1) * heights[i]);
    }
    return maxArea;
  }
}
