package puzzles;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static puzzles.LineMostPoints.*;

public class LineMostPointsTest {

    @Test
    public void testGetLineWithMostPoints() throws Exception {
        List<Point> points = Arrays.asList(
                new Point(0, 1),
                new Point(1, 0),
                new Point(0, -1),
                new Point(-1, 0),
                new Point(-2, -1)
        );
        assert getLineWithMostPoints(points).equals(new Line(1, 1));
    }
}