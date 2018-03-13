/** https://leetcode.com/problems/rotate-string/description/ */
class RotateString {
  boolean rotateString(String A, String B) {
    return (A + A).contains(B);
  }
}
