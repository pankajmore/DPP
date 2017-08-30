import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/ Created by pankaj on
 * 29/08/17.
 */
class LetterCombinationsOfAPhoneNumber {
  private static final String[] KEYS = {
    "0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
  };

  List<String> letterCombinations(final String digits) {
    List<String> ls = new ArrayList<>();
    if (digits == null || digits.isEmpty()) {
      return ls;
    }
    combinations("", digits, 0, ls);
    return ls;
  }

  List<String> letterCombinations1(final String digits) {
    List<String> ls = new ArrayList<>();
    if (digits == null || digits.length() == 0) {
      return ls;
    }
    ls.add("");
    for (int i = 0; i < digits.length(); i++) {
      List<String> curr = new ArrayList<>();
      for (char c : KEYS[digits.charAt(i) - '0'].toCharArray()) {
        for (String s : ls) {
          curr.add(s + c);
        }
      }
      ls = curr;
    }
    return ls;
  }

  private void combinations(
      final String prefix, final String digits, final int idx, final List<String> ls) {
    if (idx >= digits.length()) {
      ls.add(prefix);
    } else {
      String candidates = KEYS[digits.charAt(idx) - '0'];
      for (char c : candidates.toCharArray()) {
        combinations(prefix + c, digits, idx + 1, ls);
      }
    }
  }
}
