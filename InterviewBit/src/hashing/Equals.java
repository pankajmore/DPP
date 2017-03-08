package hashing;

import java.util.*;

/** https://www.interviewbit.com/problems/equal/ Created by pankaj on 08/03/17. */
public class Equals {
  public ArrayList<Integer> equal(ArrayList<Integer> A) {
    List<Integer> ans = new ArrayList<>();
    Map<Integer, List<Integer>> map = new HashMap<>();
    int N = A.size();
    for (int i = 0; i < N; i++) {
      for (int j = i + 1; j < N; j++) {
        int sum = A.get(i) + A.get(j);
        map.putIfAbsent(sum, Arrays.asList(i, j));
        List<Integer> pair = map.get(sum);
        int x = pair.get(0), y = pair.get(1);
        if (i != x && j != y && j != x && x < i) {
          List<Integer> curr = Arrays.asList(x, y, i, j);
          if (ans.isEmpty() || compare(curr, ans) < 0) ans = curr;
        }
      }
    }
    return new ArrayList<>(ans);
  }

  private int compare(List<Integer> A, List<Integer> B) {
    for (int i = 0; i < 4; i++) {
      if (A.get(i) < B.get(i)) return -1;
      else if (A.get(i) > B.get(i)) return 1;
    }
    return 0;
  }
}
