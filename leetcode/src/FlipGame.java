import java.util.ArrayList;
import java.util.List;

/** https://leetcode.com/problems/flip-game Created by pankaj on 29/07/17. */
class FlipGame {
  List<String> generateNextPossibleMoves(final String s) {
    List<String> possibleMoves = new ArrayList<>();
    for (int i = 0; i < s.length() - 1; i++) {
      if (s.charAt(i) == '+' && s.charAt(i + 1) == '+') {
        possibleMoves.add(s.substring(0, i) + "--" + s.substring(i + 2, s.length()));
      }
    }
    return possibleMoves;
  }
}
