import java.util.HashMap;
import java.util.Map;

/** https://leetcode.com/problems/integer-replacement/ Created by pankaj on 9/14/16. */
class IntegerReplacement {
  int integerReplacement(int n_) {
    long n = (long) n_;
    int res = 0;
    while (n > 1) {
      if (n % 2 == 0) n /= 2;
      else if (n == 3) n -= 1;
      else if (Long.numberOfTrailingZeros(n + 1) > Long.numberOfTrailingZeros(n - 1)) n += 1;
      else n -= 1;
      res++;
    }
    return res;
  }

  int integerReplacement1(int n_) {
    long n = (long) n_;
    Map<Long, Integer> map = new HashMap<>();
    map.put(1L, 0);
    return helper(n, map);
  }

  private int helper(long n, Map<Long, Integer> map) {
    if (!map.containsKey(n)) {
      if (n % 2 == 0) {
        map.put(n, 1 + helper(n / 2, map));
      } else {
        map.put(n, 1 + Math.min(helper(n - 1, map), helper(n + 1, map)));
      }
    }
    return map.get(n);
  }
}
