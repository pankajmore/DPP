package utils;

import java.util.ArrayList;
import java.util.List;

/** Created by pankaj on 4/2/16. */
public class BigNumberMultiplication {
  /**
   * Time : O(M * N) Space: O(M + N)
   *
   * @param x arbitrary precision integer with M digits
   * @param y arbitrary precision integer with N digits
   * @return another arbitrary precision integer with M + N digits
   */
  public static List<Integer> multiply(List<Integer> x, List<Integer> y) {
    int M = x.size(), N = y.size();
    boolean sign = (x.get(0) < 0) ^ (y.get(0) < 0);
    x.set(0, Math.abs(x.get(0)));
    y.set(0, Math.abs(y.get(0)));
    List<Integer> ans = new ArrayList<>(M + N);
    for (int i = 0; i < M + N; i++) ans.add(0);
    for (int i = M - 1; i >= 0; i--) {
      for (int j = N - 1; j >= 0; j--) {
        int d = ans.get(i + j + 1) + x.get(i) * y.get(j);
        int c = d / 10;
        d %= 10;
        ans.set(i + j + 1, d);
        ans.set(i + j, ans.get(i + j) + c);
      }
    }
    ans = stripLeadingZeroes(ans);
    if (sign) ans.set(0, -ans.get(0));
    return ans;
  }

  private static List<Integer> stripLeadingZeroes(List<Integer> x) {
    int i = 0, N = x.size();
    while (i < N && x.get(i) == 0) i++;
    if (i == N) return x.subList(N - 1, N);
    else return x.subList(i, N);
  }
}
