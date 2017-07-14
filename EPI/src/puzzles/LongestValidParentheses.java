package puzzles;

import java.util.Stack;

/** Created by pankaj on 3/10/16. */
class LongestValidParentheses {
  /**
   * Time : O(N) Space: O(N)
   *
   * @param s string of parentheses of length N
   * @return the longest substring in s that is a valid parentheses
   */
  String longestValidParentheses(final String s) {
    int len = s.length(), best = 0, start = 0, end = -1;
    int[] dp = new int[len];
    for (int i = 1; i < len; i++) {
      if (s.charAt(i) == ')' && i - dp[i - 1] - 1 >= 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
        if (i - dp[i - 1] - 2 >= 0) {
          dp[i] = 2 + dp[i - 1] + dp[i - dp[i - 1] - 2];
        } else {
          dp[i] = 2 + dp[i - 1];
        }
      }
      if (best < dp[i]) {
        best = dp[i];
        end = i;
        start = i - dp[i] + 1;
      }
    }
    return s.substring(start, end + 1);
  }

  String longestValidParenthesesUsingStack(final String s) {
    int len = s.length();
    Stack<Integer> stack = new Stack<>();
    for (int i = 0; i < len; i++) {
      char c = s.charAt(i);
      if (c == '(') {
        stack.push(i);
      } else {
        if (!stack.isEmpty() && s.charAt(stack.peek()) == '(') {
          stack.pop();
        } else {
          stack.push(i);
        }
      }
    }
    if (stack.isEmpty()) {
      return s;
    }
    int start = 0, end = -1, a = len, b, best = 0;
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
