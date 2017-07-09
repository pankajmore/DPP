import java.util.ArrayList;
import java.util.List;

/** https://leetcode.com/problems/solve-the-equation/ Created by pankaj on 09/07/17. */
class SolveTheEquation {
  String solveEquation(final String equation) {
    String[] lr = equation.split("=");
    int lhs = 0;
    int rhs = 0;
    for (String s : parse(lr[0])) {
      if (s.endsWith("x")) {
        lhs += Integer.parseInt(coeff(s));
      } else {
        rhs -= Integer.parseInt(s);
      }
    }
    for (String s : parse(lr[1])) {
      if (s.endsWith("x")) {
        lhs -= Integer.parseInt(coeff(s));
      } else {
        rhs += Integer.parseInt(s);
      }
    }
    if (lhs == 0) {
      if (rhs == 0) {
        return "Infinite solutions";
      } else {
        return "No solution";
      }
    } else {
      return String.format("x=%d", rhs / lhs);
    }
  }

  private List<String> parse(final String s) {
    List<String> terms = new ArrayList<>();
    String t = "";
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (c == '+' || c == '-') {
        if (t.length() > 0) {
          terms.add(t);
        }
        t = "" + c;
      } else {
        t += c;
      }
    }
    terms.add(t);
    return terms;
  }

  private String coeff(final String s) {
    if (s.length() > 1 && s.charAt(s.length() - 2) >= '0' && s.charAt(s.length() - 2) <= '9') {
      return s.replace("x", "");
    } else {
      return s.replace("x", "1");
    }
  }
}
