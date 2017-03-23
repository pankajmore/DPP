package puzzles;

import java.util.List;

/** Created by pankaj on 4/27/16. */
public class IdentifyCelebrity {
  public static int identifyCelebrity(List<List<Boolean>> A) {
    int N = A.size();
    int i = 0, j = 0;
    while (i < N && j < N) {
      if (A.get(i).get(j)) i++;
      else j++;
    }
    return j;
  }
}
