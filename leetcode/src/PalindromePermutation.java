import java.util.HashSet;
import java.util.Set;

/** https://leetcode.com/problems/palindrome-permutation Created by pankaj on 29/07/17. */
class PalindromePermutation {
  boolean canPermutePalindrome(final String s) {
    Set<Character> set = new HashSet<>();
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (!set.add(c)) {
        set.remove(c);
      }
    }
    return set.size() <= 1;
  }
}
