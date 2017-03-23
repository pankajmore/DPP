package puzzles;

import org.junit.Test;

import static puzzles.RunLengthEncoding.decode;
import static puzzles.RunLengthEncoding.encode;

/** Created by pankaj on 2/8/16. */
public class RunLengthEncodingTest {

  @Test
  public void testEncode() throws Exception {
    assert encode("").equals("");
    assert encode("a").equals("1a");
    assert encode("aaaabbcccaa").equals("4a2b3c2a");
    assert encode("aaaaaaaaaaffffee").equals("10a4f2e");
  }

  @Test
  public void testDecode() throws Exception {
    assert decode("").equals("");
    assert decode("1a").equals("a");
    assert decode("4a2b3c2a").equals("aaaabbcccaa");
    assert decode("10a4f2e").equals("aaaaaaaaaaffffee");
  }
}
