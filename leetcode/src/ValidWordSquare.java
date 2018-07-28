import java.util.List;

/** https://leetcode.com/problems/valid-word-square Created by pankaj on 10/16/16. */
public class ValidWordSquare {
  public boolean validWordSquare(List<String> words) {
    for (int i = 0; i < words.size(); i++) {
      for (int j = 0; j < words.get(i).length(); j++) {
        if (j >= words.size()
            || i >= words.get(j).length()
            || words.get(i).charAt(j) != words.get(j).charAt(i)) return false;
      }
    }
    return true;
  }
}
