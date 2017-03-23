package puzzles;

import org.junit.Test;

import static puzzles.RPN.eval;

public class RPNTest {

  @Test
  public void testEval() throws Exception {
    assert eval("3,4,*,1,2,+,+") == 15;
    assert eval("1,1,+,-2,*") == -4;
    assert eval("4,6,/,2,/") == 0;

    assert (0 == eval("2,-10,/"));
    assert (-5 == eval("-10,2,/"));
    assert (5 == eval("-10,-2,/"));
    assert (-5 == eval("5,10,-"));
    assert (6 == eval("-10,-16,-"));
    assert (12 == eval("10,2,+"));
    assert (15 == eval("1,2,+,3,4,*,+"));
    assert (42 == eval("1,2,3,4,5,+,*,+,+,3,4,*,+"));
    assert (-6 == eval("1,2,3,4,5,+,*,+,+,3,4,*,+,-7,/"));
  }
}
