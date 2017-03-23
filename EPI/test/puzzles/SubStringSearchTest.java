package puzzles;

import org.junit.Test;

import static puzzles.SubStringSearch.search;

public class SubStringSearchTest {

  @Test
  public void testSearch() throws Exception {
    assert search("foo", "foo") == 0;
    assert search("foo", "foobar") == 0;
    assert search("foo", "barfoo") == 3;
    assert search("foo", "abfobar") == -1;
    assert search("foo", "foofoo") == 0;
  }
}
