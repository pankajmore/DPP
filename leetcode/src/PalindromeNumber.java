/** https://leetcode.com/problems/palindrome-number/ Created by pankaj on 9/27/16. */
public class PalindromeNumber {
  public boolean isPalindrome(int x) {
    if (x < 0 || (x != 0 && x % 10 == 0)) return false;
    int r = 0;
    while (x > r) {
      r = r * 10 + x % 10;
      x /= 10;
    }
    return x == r || x == r / 10;
  }
}
