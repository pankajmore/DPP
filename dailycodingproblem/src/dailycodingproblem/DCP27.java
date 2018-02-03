package dailycodingproblem;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Given a string of round, curly, and square open and closing brackets, return whether the brackets
 * are balanced (well-formed).
 * <p>
 * <p>https://leetcode.com/problems/valid-parentheses/description/
 */
class DCP27 {
    static boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (c == '{' || c == '[' || c == '(') {
                stack.push(c);
            } else if (stack.isEmpty()) {
                return false;
            } else {
                char d = stack.pop();
                if (!((c == '}' && d == '{') || (c == ']' && d == '[') || (c == ')' && d == '('))) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
