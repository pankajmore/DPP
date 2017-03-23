package puzzles;

import org.junit.Test;
import puzzles.IntersectRectangle.Rectangle;

import static puzzles.IntersectRectangle.intersectRectangle;

public class IntersectRectangleTest {

  @Test
  public void testIntersectRectangle() throws Exception {
    Rectangle R1, R2;
    R1 = new Rectangle(0, 0, 2, 2);
    R2 = new Rectangle(1, 1, 3, 3);
    Rectangle result = intersectRectangle(R1, R2);
    assert (result.x == 1 && result.y == 1 && result.width == 1 && result.height == 1);
    R1 = new Rectangle(0, 0, 1, 1);
    R2 = new Rectangle(1, 1, 3, 3);
    result = intersectRectangle(R1, R2);
    assert (result.x == 1 && result.y == 1 && result.width == 0 && result.height == 0);
    R1 = new Rectangle(0, 0, 1, 1);
    R2 = new Rectangle(2, 2, 3, 3);
    result = intersectRectangle(R1, R2);
    assert (result.x == 0 && result.y == 0 && result.width == -1 && result.height == -1);
  }
}
