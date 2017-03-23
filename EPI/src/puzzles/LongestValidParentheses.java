package puzzles;

import java.util.Stack;

/** Created by pankaj on 3/10/16. */
public class LongestValidParentheses {
  /**
   * Time : O(N) Space: O(N)
   *
   * @param s string of parentheses of length N
   * @return the longest substring in s that is a valid parentheses
   */
  public static String longestValidParentheses(String s) {
    int N = s.length(), best = 0, start = 0, end = -1;
    int[] dp = new int[N];
    for (int i = 1; i < N; i++) {
      if (s.charAt(i) == ')' && i - dp[i - 1] - 1 >= 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
        dp[i] = 2 + dp[i - 1] + (i - dp[i - 1] - 2 >= 0 ? dp[i - dp[i - 1] - 2] : 0);
      }
      if (best < dp[i]) {
        best = dp[i];
        end = i;
        start = i - dp[i] + 1;
      }
    }
    return s.substring(start, end + 1);
  }

  public static String longestValidParenthesesUsingStack(String s) {
    int N = s.length();
    Stack<Integer> stack = new Stack<>();
    for (int i = 0; i < N; i++) {
      char c = s.charAt(i);
      if (c == '(') stack.push(i);
      else {
        if (!stack.isEmpty() && s.charAt(stack.peek()) == '(') stack.pop();
        else stack.push(i);
      }
    }
    if (stack.isEmpty()) return s;
    int start = 0, end = -1, a = N, b, best = 0;
    while (!stack.isEmpty()) {
      b = stack.pop();
      if (best <= a - b - 1) {
        best = a - b - 1;
        start = b + 1;
        end = a - 1;
      }
      a = b;
    }
    // consider the valid string starting from beginning
    if (best <= a) {
      start = 0;
      end = a - 1;
    }
    return s.substring(start, end + 1);
  }
}
