package arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * https://www.interviewbit.com/problems/repeat-and-missing-number-array/ Created by pankaj on
 * 11/03/17.
 */
public class RepeatAndMissingNumberArray {
  public ArrayList<Integer> repeatedNumber(final List<Integer> Arr) {
    int N = Arr.size();
    int x = 0;
    for (int i = 0; i < N; i++) {
      x ^= (i + 1) ^ Arr.get(i);
    }
    int s = lowestSetBit(x);
    int p = 0, q = 0;
    for (int i = 0; i < N; i++) {
      if (((i + 1) >> s & 1) == 0) {
        p ^= i + 1;
      } else {
        q ^= i + 1;
      }
      if ((Arr.get(i) >> s & 1) == 0) {
        p ^= Arr.get(i);
      } else {
        q ^= Arr.get(i);
      }
    }
    int A, B;
    if (Arr.indexOf(p) == -1) {
      A = q;
      B = p;
    } else {
      A = p;
      B = q;
    }
    ArrayList<Integer> res = new ArrayList<>();
    res.add(A);
    res.add(B);
    return res;
  }

  private int lowestSetBit(int x) {
    for (int i = 0; i < 32; i++) {
      if ((x >> i & 1) == 1) return i;
    }
    return -1;
  }
}
