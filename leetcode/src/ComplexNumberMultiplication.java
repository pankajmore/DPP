/**
 * https://leetcode.com/contest/leetcode-weekly-contest-25/problems/complex-number-multiplication/
 * Created by pankaj on 26/03/17.
 */
class ComplexNumberMultiplication {
  String complexNumberMultiply(String a, String b) {
    int[] x = parse(a);
    int[] y = parse(b);
    int c = x[0] * y[0] - x[1] * y[1];
    int d = x[0] * y[1] + y[0] * x[1];
    return String.format("%d+%di", c, d);
  }

  private int[] parse(String s) {
    int[] x = new int[2];
    int i = 0, N = s.length();
    StringBuilder sb = new StringBuilder();
    while (i < N && s.charAt(i) != '+') {
      sb.append(s.charAt(i++));
    }
    i++;
    x[0] = Integer.valueOf(sb.toString());
    sb = new StringBuilder();
    while (i < N && s.charAt(i) != 'i') {
      sb.append(s.charAt(i++));
    }
    x[1] = Integer.valueOf(sb.toString());
    return x;
  }
}
