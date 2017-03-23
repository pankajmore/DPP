package puzzles;

import org.junit.Test;

import static puzzles.NumberWaysObstacles.numberOfWaysWithObstacles;

public class NumberWaysObstaclesTest {

  @Test
  public void testNumberOfWaysWithObstacles() throws Exception {
    boolean[][] B = {{false, false}, {false, false}};
    assert numberOfWaysWithObstacles(B) == 2;

    B =
        new boolean[][] {
          {false, false, false}, {false, false, false}, {false, true, false}, {true, false, false},
        };
    assert numberOfWaysWithObstacles(B) == 3;
  }
}
