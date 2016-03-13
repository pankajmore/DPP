import org.junit.Test;

/**
 * Created by pankaj on 3/13/16.
 */
public class KnightOnChessBoardTest {

    @Test
    public void testShortestPath() throws Exception {
        assert KnightOnChessBoard.shortestPath(8, 8, 1, 1, 8, 8) == 6;
    }
}