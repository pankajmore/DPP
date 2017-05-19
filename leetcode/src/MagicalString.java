import java.util.ArrayList;
import java.util.List;

/** https://leetcode.com/problems/magical-string/ Created by pankaj on 19/05/17. */
class MagicalString {
  int magicalString(final int n) {
    if (n == 0) {
      return 0;
    }
    List<Integer> seq = new ArrayList<>();
    seq.add(1);
    int numOnes = 1;
    int remaining = 0;
    int idx = 0;
    int curr = 1;
    while (seq.size() < n) {
      if (remaining == 0) {
        if (curr == 1) {
          curr = 2;
        } else {
          curr = 1;
        }
        seq.add(curr);
        remaining = seq.get(++idx) - 1;
      } else {
        seq.add(curr);
        remaining--;
      }
      if (curr == 1) {
        numOnes++;
      }
    }
    return numOnes;
  }
}
