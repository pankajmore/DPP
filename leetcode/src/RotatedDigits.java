/** https://leetcode.com/problems/rotated-digits/description/ */
class RotatedDigits {
  int rotatedDigits(int N) {
    int cnt = 0;
    for (int i = 1; i <= N; i++) {
      if (isGood(i)) {
        cnt++;
      }
    }
    return cnt;
  }

  private boolean isGood(int x) {
    boolean diff = false;
    while (x > 0) {
      int d = x % 10;
      x /= 10;
      if (d == 3 || d == 4 || d == 7) {
        return false;
      } else if (d == 2 || d == 5 || d == 6 || d == 9) {
        diff = true;
      }
    }
    return diff;
  }
}
