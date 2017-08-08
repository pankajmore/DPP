/** https://leetcode.com/problems/largest-palindrome-product/ Created by pankaj on 09/08/17. */
class LargestPalindromeProduct {
  int largestPalindrome(final int n) {
    long x = (long) Math.pow(10, n) - 1;
    for (long i = x; i > x / 10; i--) {
      for (long j = i; j > x / 10; j--) {
        long p = i * j;
        if (isPalindrome(p)) {
          return (int) (p % 1337);
        }
      }
    }
    return 1;
  }

  private boolean isPalindrome(final long x) {
    long n = x;
    long r = 0;
    while (n > 0) {
      r = r * 10 + n % 10;
      n /= 10;
    }
    return r == x;
  }
}
