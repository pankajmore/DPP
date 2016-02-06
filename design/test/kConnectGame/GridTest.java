package DPP.design.test.kConnectGame;

import kConnectGame.Grid;
import kConnectGame.Player;
import kConnectGame.exceptions.BoardFullException;
import kConnectGame.exceptions.ColumnFullException;
import kConnectGame.exceptions.ColumnOutOfRangeException;
import org.junit.Test;

/**
 * Created by pankaj on 2/6/16.
 */
public class GridTest {

    @Test
    public void testInsert() throws Exception {
        Grid grid = new Grid(5, 5);
        Player p = new Player("A");
        try {
            grid.insert(p, -1);
        } catch (ColumnOutOfRangeException e) {
            assert true;
        } catch (ColumnFullException | BoardFullException e) {
            assert false;
        }

        try {
            grid.insert(p, 1);
            grid.insert(p, 2);
            grid.insert(p, 3);
            grid.insert(p, 4);
            grid.insert(p, 5);
        } catch (ColumnOutOfRangeException | BoardFullException e) {
            assert false;
        } catch (ColumnFullException e) {
            assert true;
        }

        // similar test for BoardFull Scenario
    }
}