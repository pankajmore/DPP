package puzzles;

import org.junit.Test;
import org.junit.contrib.theories.Theories;
import org.junit.runner.RunWith;

import java.util.ArrayList;

@RunWith(Theories.class)
public class OddEvenTest {

  @Test
  public void testOddEvenInterleave() throws Exception {
    int N = 100;
    ArrayList<Integer> expected = new ArrayList<>();
    for (int i = 1; i <= N; i++) expected.add(i);
    assert OddEven.oddEvenInterleave(N).equals(expected);
  }
}
