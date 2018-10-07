import java.util.HashSet;

/** https://leetcode.com/problems/happy-number/ Created by pankaj on 21/12/16. */
class HappyNumber {
  boolean isHappy(int n) {
    HashSet<Integer> visited = new HashSet<>();
    if (n <= 0) return false;
    while (n > 1) {
      if (visited.contains(n)) return false;
      visited.add(n);
      int s = 0;
      while (n > 0) {
        int d = n % 10;
        s += d * d;
        n = n / 10;
      }
      n = s;
    }
    return true;
  }
}
