package DPP.design.test.kConnectGame;

import kConnectGame.*;
import kConnectGame.exceptions.ColumnFullException;
import kConnectGame.exceptions.ColumnOutOfRangeException;
import kConnectGame.exceptions.IncorrectTurnException;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * Created by pankaj on 2/6/16.
 */
public class ConnectKGameTest {
    @Test
    public void testIncorrectTurn() throws ColumnFullException, ColumnOutOfRangeException, IncorrectTurnException {
        Grid grid = new Grid(5, 5);
        Player A = new Player("A"), B = new Player("B");
        List<Player> players = Arrays.asList(A, B);
        List<WinningStrategy> strategies = Arrays.asList(new HorizontalWinningStrategy(3), new VerticalWinningStrategy(3));
        ConnectKGame game = new ConnectKGame(grid, players, strategies);
        game.play(A, 1);
        try {
            game.play(A, 2);
        } catch (IncorrectTurnException e) {
            assert true;
            return;
        }
        assert false;
    }
}