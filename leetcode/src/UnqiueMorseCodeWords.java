import java.util.HashSet;
import java.util.Set;

/** https://leetcode.com/problems/unique-morse-code-words/description/ */
class UnqiueMorseCodeWords {
  private static String[] MORSE =
      new String[] {
        ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--",
        "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."
      };

  int uniqueMorseRepresentations(String[] words) {
    Set<String> morses = new HashSet<>();
    for (String word : words) {
      StringBuilder sb = new StringBuilder();
      for (char c : word.toCharArray()) {
        sb.append(MORSE[c - 'a']);
      }
      morses.add(sb.toString());
    }
    return morses.size();
  }
}
