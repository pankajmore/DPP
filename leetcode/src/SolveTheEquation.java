/** https://leetcode.com/problems/solve-the-equation/ Created by pankaj on 09/07/17. */
class SolveTheEquation {
  public String solveEquation(final String equation) {
    String[] lr = equation.split("=");
    EqCoeff lhs = evaluate(lr[0]);
    EqCoeff rhs = evaluate(lr[1]);
    EqCoeff eq = new EqCoeff(lhs.coeffX - rhs.coeffX, rhs.coeffV - lhs.coeffV);
    return eq.toString();
  }

  private EqCoeff evaluate(final String expr) {
    String[] tokens = expr.split("(?=[+-])");
    int coeffX = 0;
    int coeffV = 0;
    for (String token : tokens) {
      if (token.equals("+x") || token.equals("x")) {
        coeffX += 1;
      } else if (token.equals("-x")) {
        coeffX -= 1;
      } else if (token.contains("x")) {
        coeffX += Integer.parseInt(token.substring(0, token.indexOf("x")));
      } else {
        coeffV += Integer.parseInt(token);
      }
    }
    return new EqCoeff(coeffX, coeffV);
  }

  private class EqCoeff {
    private int coeffX;
    private int coeffV;

    EqCoeff(final int x, final int v) {
      coeffX = x;
      coeffV = v;
    }

    @Override
    public String toString() {
      if (coeffX == 0) {
        if (coeffV == 0) {
          return "Infinite solutions";
        } else {
          return "No solution";
        }
      } else {
        return "x=" + (coeffV / coeffX);
      }
    }
  }
}
