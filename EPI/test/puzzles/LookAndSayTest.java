package puzzles;

import org.junit.Test;

import java.util.Arrays;

import static puzzles.LookAndSay.lookAndSayList;

public class LookAndSayTest {

  @Test
  public void testLookAndSayList() throws Exception {
    assert Arrays.asList("1", "11", "21", "1211", "111221", "312211", "13112221", "1113213211")
        .equals(lookAndSayList(8));
  }
}
