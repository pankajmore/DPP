package puzzles;

import org.junit.Test;

import java.util.Arrays;

import static puzzles.LevenshteinDistance.*;

public class LevenshteinDistanceTest {

  @Test
  public void testEditDistanceRecursive() throws Exception {
    assert editDistanceRecursive("", "") == 0;
    assert editDistanceRecursive("", "foo") == 3;
    assert editDistanceRecursive("foo", "") == 3;
    assert editDistanceRecursive("foo", "foo") == 0;
    assert editDistanceRecursive("goo", "google") == 3;
    assert editDistanceRecursive("google", "googol") == 2;
  }

  @Test
  public void testEditDistance() throws Exception {
    assert editDistance("", "") == 0;
    assert editDistance("", "foo") == 3;
    assert editDistance("foo", "") == 3;
    assert editDistance("foo", "foo") == 0;
    assert editDistance("a", "b") == 1;
    assert editDistance("xay", "bac") == 2;
    assert editDistance("google", "googol") == 2;
    assert editDistance("nitina", "anitin") == 2;
  }

  @Test
  public void testEditDistanceInsertAndDeleteOnly() throws Exception {
    assert editDistanceInsertAndDeleteOnly("", "") == 0;
    assert editDistanceInsertAndDeleteOnly("", "foo") == 3;
    assert editDistanceInsertAndDeleteOnly("foo", "foo") == 0;
    assert editDistanceInsertAndDeleteOnly("a", "b") == 2;
    assert editDistanceInsertAndDeleteOnly("xay", "bac") == 4;
    assert editDistanceInsertAndDeleteOnly("google", "googol") == 2;
    assert editDistanceInsertAndDeleteOnly("nitina", "anitin") == 2;
  }

  @Test
  public void testEditDistanceOps() throws Exception {
    assert editDistanceOps("", "").isEmpty();
    assert editDistanceOps("", "foo").equals(Arrays.asList(Ops.Insert, Ops.Insert, Ops.Insert));
    assert editDistanceOps("foo", "foo").isEmpty();
    assert editDistanceOps("a", "b").equals(Arrays.asList(Ops.Edit));
    assert editDistanceOps("xay", "bac").equals(Arrays.asList(Ops.Edit, Ops.Edit));
    assert editDistanceOps("google", "googol").equals(Arrays.asList(Ops.Edit, Ops.Edit));
    assert editDistanceOps("nitina", "anitin").equals(Arrays.asList(Ops.Insert, Ops.Delete));
  }
}
