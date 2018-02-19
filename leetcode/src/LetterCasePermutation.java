import java.util.ArrayList;
import java.util.List;

/** https://leetcode.com/problems/letter-case-permutation/ */
class LetterCasePermutation {
  List<String> letterCasePermutation(String s) {
    StringBuilder sb = new StringBuilder().append(s);
    List<String> permutations = new ArrayList<>();
    letterCasePermutationInternal(s, 0, sb, permutations);
    return permutations;
  }

  private void letterCasePermutationInternal(
      String s, int idx, StringBuilder sb, List<String> permutations) {
    if (idx == s.length()) {
      permutations.add(sb.toString());
    } else {
      char c = s.charAt(idx);
      if (Character.isLetter(c)) {
        char lo = Character.toLowerCase(c);
        char up = Character.toUpperCase(c);
        sb.setCharAt(idx, lo);
        letterCasePermutationInternal(s, idx + 1, sb, permutations);
        sb.setCharAt(idx, up);
        letterCasePermutationInternal(s, idx + 1, sb, permutations);
      } else {
        letterCasePermutationInternal(s, idx + 1, sb, permutations);
      }
    }
  }
}
