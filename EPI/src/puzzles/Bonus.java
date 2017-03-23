package puzzles;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/** Created by pankaj on 3/11/16. */
public class Bonus {
  /**
   * Time : O(NLogN) Space: O(N)
   *
   * @param A list of productivity of N employees
   * @return list of bonus of each employee such that if a is a neighbour of b and a is more
   *     productive than a must get higher bonus
   */
  public static List<Integer> calculateBonus(List<Integer> A) {
    int N = A.size();
    List<EmployeeData> list = new ArrayList<>();
    for (int i = 0; i < N; i++) {
      list.add(new EmployeeData(i, A.get(i)));
    }
    Collections.sort(list);
    List<Integer> bonus = new ArrayList<>();
    for (int i = 0; i < N; i++) bonus.add(0);
    for (EmployeeData employeeData : list) {
      int pos = employeeData.pos;
      int max = 0;
      if (pos - 1 >= 0 && A.get(pos - 1) < A.get(pos)) max = Math.max(max, bonus.get(pos - 1));
      if (pos + 1 < N && A.get(pos + 1) < A.get(pos)) max = Math.max(max, bonus.get(pos + 1));
      bonus.set(pos, max + 1);
    }
    return bonus;
  }

  /**
   * Time : O(N) Space: O(N)
   *
   * @param A list of productivity of N employees
   * @return list of bonus of each employee such that if a is a neighbour of b and a is more
   *     productive than a must get higher bonus
   */
  public static List<Integer> calculateBonusFast(List<Integer> A) {
    int N = A.size();
    List<Integer> T = new ArrayList<>();
    for (int i = 0; i < N; i++) T.add(1);
    for (int i = 1; i < N; i++) {
      if (A.get(i) > A.get(i - 1)) T.set(i, Math.max(T.get(i), T.get(i - 1) + 1));
    }
    for (int i = N - 2; i >= 0; i--) {
      if (A.get(i) > A.get(i + 1)) T.set(i, Math.max(T.get(i), T.get(i + 1) + 1));
    }
    return T;
  }

  private static class EmployeeData implements Comparable<EmployeeData> {
    public final int pos, val;

    private EmployeeData(int pos, int val) {
      this.pos = pos;
      this.val = val;
    }

    @Override
    public int compareTo(EmployeeData o) {
      return Integer.compare(this.val, o.val);
    }
  }
}
