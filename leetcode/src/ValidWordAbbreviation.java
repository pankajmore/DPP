/** https://leetcode.com/problems/valid-word-abbreviation Created by pankaj on 03/08/17. */
class ValidWordAbbreviation {
  boolean isValidAbbreviation(final String word, final String abbr) {
    int idx = 0;
    int num = 0;
    for (char c : abbr.toCharArray()) {
      if (Character.isDigit(c)) {
        num = num * 10 + c - '0';
        if (num < 0) {
          return false;
        }
      } else {
        idx = idx + num;
        num = 0;
        if (idx >= word.length() || c != word.charAt(idx)) {
          return false;
        } else {
          idx++;
        }
      }
    }
    idx = idx + num;
    return idx == word.length();
  }
}
