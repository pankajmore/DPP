package puzzles;

import java.util.Stack;

/** Created by Pankaj on 11/26/15. */
public class ValidParentheses {
  public static boolean isWellFormed(String s) {
    Stack<Character> stack = new Stack<>();
    for (Character c : s.toCharArray()) {
      if (c == '(' || c == '[' || c == '{') stack.push(c);
      else {
        if (stack.isEmpty() || !match(stack.peek(), c)) return false;
        stack.pop();
      }
    }
    return stack.isEmpty();
  }

  private static boolean match(Character open, Character close) {
    if (open == '(') return close == ')';
    if (open == '[') return close == ']';
    return close == '}';
  }
}
