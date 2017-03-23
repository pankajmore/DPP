package puzzles;

import org.junit.Test;

import java.util.List;

import static puzzles.GenerateParentheses.generateBalancedParentheses;

/** Created by pankaj on 3/19/16. */
public class GenerateParenthesesTest {

  @Test
  public void testGenerateBalancedParentheses() throws Exception {
    List<String> result = generateBalancedParentheses(1);
    assert (result.size() == 1 && result.get(0).equals("()"));
    result = generateBalancedParentheses(2);
    assert result.size() == 2
        && ((result.get(0).equals("(())") && result.get(1).equals("()()"))
            || (result.get(0).equals("()()") && result.get(1).equals("(())")));
  }
}
