package puzzles;

import org.junit.Test;

import static puzzles.SpreadsheetEncoding.ssDecodeColID;

public class SpreadsheetEncodingTest {

  @Test
  public void testSsDecodeColID() {
    assert ssDecodeColID("A") == 1;
    assert ssDecodeColID("Z") == 26;
    assert ssDecodeColID("AA") == 27;
    assert ssDecodeColID("AAA") == 1 + 26 + 26 * 26;
  }
}
