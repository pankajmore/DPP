package puzzles;

/** Created by Pankaj on 10/23/15. */
public class RegularExpression {
  public static boolean isMatch(String regex, String s) {
    if (regex.charAt(0) == '^') return isMatchHere(regex.substring(1), s);
    for (int i = 0; i <= s.length(); i++) if (isMatchHere(regex, s.substring(i))) return true;
    return false;
  }

  private static boolean isMatchHere(String regex, String s) {
    if (regex.isEmpty()) return true;
    if ("$".equals(regex)) return s.isEmpty();
    if (regex.length() >= 2 && regex.charAt(1) == '*') {
      for (int i = 0;
          i < s.length() && (regex.charAt(0) == '.' || regex.charAt(0) == s.charAt(i));
          i++) {
        if (isMatchHere(regex.substring(2), s.substring(i + 1))) return true;
      }
      return isMatchHere(regex.substring(2), s);
    }

    return !s.isEmpty()
        && (regex.charAt(0) == '.' || regex.charAt(0) == s.charAt(0))
        && isMatchHere(regex.substring(1), s.substring(1));
  }
}
