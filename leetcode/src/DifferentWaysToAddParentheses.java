import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/different-ways-to-add-parentheses/ Created by pankaj on 09/06/17.
 */
class DifferentWaysToAddParentheses {
  List<Integer> diffWaysToCompute(final String input) {
    List<Integer> res = new ArrayList<>();
    for (int i = 0; i < input.length(); i++) {
      char c = input.charAt(i);
      if (c == '+' || c == '-' || c == '*') {
        List<Integer> left = diffWaysToCompute(input.substring(0, i));
        List<Integer> right = diffWaysToCompute(input.substring(i + 1, input.length()));
        for (int l : left) {
          for (int r : right) {
            if (c == '+') {
              res.add(l + r);
            } else if (c == '-') {
              res.add(l - r);
            } else {
              res.add(l * r);
            }
          }
        }
      }
    }
    if (res.isEmpty()) {
      res.add(Integer.parseInt(input));
    }
    return res;
  }
}
