package puzzles;

import org.junit.Assert;
import org.junit.Test;

import static puzzles.NormalizedPathnames.shortestEquivalentPath;

public class NormalizedPathnamesTest {

  @Test
  public void testShortestEquivalentPath() throws Exception {
    Assert.assertEquals("123/456", shortestEquivalentPath("123/456"));
    Assert.assertEquals("/123/456", shortestEquivalentPath("/123/456"));
    Assert.assertEquals("usr/bin/gcc", shortestEquivalentPath("usr/lib/../bin/gcc"));
    Assert.assertEquals("..", shortestEquivalentPath("./../"));
    Assert.assertEquals("../../local", shortestEquivalentPath("../../local"));
    Assert.assertEquals("../../local", shortestEquivalentPath("./.././../local"));
    Assert.assertEquals("/", shortestEquivalentPath("/foo/../foo/./../"));
    try {
      shortestEquivalentPath("/..");
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
    }
    try {
      shortestEquivalentPath("/cpp_name/bin/");
    } catch (Exception e) {
      System.out.println(e.getMessage());
      Assert.assertFalse(true);
    }
    Assert.assertEquals(
        "scripts/awkscripts", shortestEquivalentPath("scripts//./../scripts/awkscripts/././"));
  }
}
