package puzzles;

/** Created by Pankaj on 11/29/15. */
public class SquareRoot {
  public static double EPS = 0.0001;

  public static double squareRoot(double x) {
    boolean inverted = false;
    if (x == 0) return 0;
    if (x < 1) {
      x = 1 / x;
      inverted = true;
    }
    double l = 0, h = x, m = 0;
    while (l <= h) {
      m = (l + h) / 2.0;
      if (Math.abs((m * m - x) / x) <= EPS) return inverted ? 1 / m : m;
      if (m * m > x) h = m;
      else l = m;
    }
    return inverted ? 1 / m : m;
  }
}
