import java.util.ArrayList;
import java.util.List;

/** https://leetcode.com/problems/gray-code/ Created by pankaj on 18/08/17. */
class GrayCode {
  List<Integer> grayCode(final int n) {
    List<Integer> codes = new ArrayList<>();
    codes.add(0);
    if (n == 0) {
      return codes;
    }
    codes.add(1);
    for (int i = 1; i < n; i++) {
      for (int j = 0; j < (1 << i); j++) {
        int x = (1 << i) | codes.get((1 << i) - 1 - j);
        codes.add(x);
      }
    }
    return codes;
  }
}
