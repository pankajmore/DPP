/** https://leetcode.com/problems/count-binary-substrings/description/ */
class CountBinarySubstrings {
  int countBinarySubstrings(String s) {
    int zeros = 0;
    int ones = 0;
    int cnt = 0;
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (i > 0 && c != s.charAt(i - 1)) {
        cnt += Math.min(zeros, ones);
        if (c == '0') {
          zeros = 0;
        } else {
          ones = 0;
        }
      }
      if (c == '0') {
        zeros++;
      } else {
        ones++;
      }
    }
    cnt += Math.min(zeros, ones);
    return cnt;
  }
}
