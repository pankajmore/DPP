package puzzles;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/** Created by Pankaj on 10/25/15. */
public class MonotonicDecimals {
  public static int numberOfMonotonicDecimals(int length) {
    if (length == 0) return 0;
    int[] C = new int[10];
    for (int i = 0; i < 10; i++) C[i] = i;
    for (int k = 2; k <= length; k++) for (int i = 2; i < 10; i++) C[i] += C[i - 1];
    return C[9];
  }

  public static int numberOfStrictlyMonotonicDecimals(int length) {
    if (length == 0) return 0;
    int[] C = new int[10];
    int prev;
    for (int i = 0; i < 10; i++) C[i] = i;
    for (int k = 2; k <= length; k++) {
      prev = C[0];
      for (int i = 1; i < 10; i++) {
        int temp = C[i];
        C[i] = C[i - 1] + prev;
        prev = temp;
      }
    }
    return C[9];
  }

  public static List<Integer> monotonicDecimalsRecursive(int length) {
    List<Integer> ls = new ArrayList<>();
    if (length == 1) return Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
    for (Integer x : monotonicDecimalsRecursive(length - 1)) {
      for (int r = x % 10; r < 10; r++) ls.add(x * 10 + r);
    }
    return ls;
  }

  public static List<Integer> strictlyMonotonicDecimalsRecursive(int length) {
    List<Integer> ls = new ArrayList<>();
    if (length == 1) return Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
    for (Integer x : strictlyMonotonicDecimalsRecursive(length - 1)) {
      for (int r = x % 10 + 1; r < 10; r++) ls.add(x * 10 + r);
    }
    return ls;
  }
}
