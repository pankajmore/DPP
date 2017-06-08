import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/different-ways-to-add-parentheses/ Created by pankaj on 09/06/17.
 */
class DifferentWaysToAddParentheses {
  List<Integer> diffWaysToCompute(final String input) {
    String[] ls = input.split("[*+-]");
    List<Character> ops = new ArrayList<>();
    int idx = 0;
    for (int i = 0; i < ls.length - 1; i++) {
      idx += ls[i].length();
      ops.add(input.charAt(idx));
      idx++;
    }
    List<Integer> vals = Arrays.stream(ls).map(Integer::parseInt).collect(Collectors.toList());
    System.out.println(vals.toString());
    System.out.println(ops.toString());
    return diffWays(vals, ops, 0, vals.size() - 1);
  }

  private List<Integer> diffWays(
      final List<Integer> vals, final List<Character> ops, final int lo, final int hi) {
    if (lo == hi) {
      return Arrays.asList(vals.get(lo));
    } else {
      List<Integer> res = new ArrayList<>();
      for (int i = lo; i < hi; i++) {
        List<Integer> left = diffWays(vals, ops, lo, i);
        List<Integer> right = diffWays(vals, ops, i + 1, hi);
        for (int l : left) {
          for (int r : right) {
            char c = ops.get(i);
            int v = 0;
            if (c == '+') {
              v = l + r;
            } else if (c == '-') {
              v = l - r;
            } else if (c == '*') {
              v = l * r;
            } else {
              System.out.println(c);
              throw new IllegalArgumentException();
            }
            res.add(v);
          }
        }
      }
      return res;
    }
  }
}
