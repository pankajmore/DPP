package puzzles;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OnlineMedianTest {
  @Test
  public void smallTest() {
    List<Integer> stream = Arrays.asList(5, 4, 3, 2, 1);
    List<Double> expected = Arrays.asList(5.0, 4.5, 4.0, 3.5, 3.0);
    checkAns(stream, expected);

    stream = Arrays.asList(1, 2, 3, 4, 5);
    expected = Arrays.asList(1.0, 1.5, 2.0, 2.5, 3.0);
    checkAns(stream, expected);

    stream = Arrays.asList(1, 0, 3, 5, 2, 0, 1);
    expected = Arrays.asList(1.0, 0.5, 1.0, 2.0, 2.0, 1.5, 1.0);
    checkAns(stream, expected);

    stream = Arrays.asList(-1);
    expected = Arrays.asList(-1.0);
    checkAns(stream, expected);
  }

  private void checkAns(List<Integer> stream, List<Double> expected) {
    List<Double> results = new ArrayList<>();
    OnlineMedian onlineMedian = new OnlineMedian();
    for (Integer x : stream) {
      onlineMedian.add(x);
      results.add(onlineMedian.median());
    }
    assert results.equals(expected);
  }
}
