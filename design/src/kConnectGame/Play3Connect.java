package kConnectGame;

import kConnectGame.exceptions.ColumnFullException;
import kConnectGame.exceptions.ColumnOutOfRangeException;
import kConnectGame.exceptions.IncorrectTurnException;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static kConnectGame.ConnectKGame.GameState.RUNNING;
import static kConnectGame.ConnectKGame.GameState.TIE;

/**
 * Created by pankaj on 2/6/16.
 */
public class Play3Connect {
    public static void main(String[] args) {
        int numRows = 5, numCols = 5;
        int k = 3;
        Grid grid = new Grid(numRows, numCols);
        List<Player> players = Arrays.asList(new Player("A"), new Player("B"));
        List<WinningStrategy> strategies = Arrays.asList(new HorizontalWinningStrategy(k), new VerticalWinningStrategy(k));
        ConnectKGame game = new ConnectKGame(grid, players, strategies);
        Scanner in = new Scanner(System.in);
        Player currentPlayer = null;
        while (game.getState() == RUNNING) {
            currentPlayer = new Player(in.next());
            int col = in.nextInt();
            try {
                game.play(currentPlayer, col);
            } catch (ColumnOutOfRangeException | ColumnFullException | IncorrectTurnException e) {
                System.out.println(e.getMessage());
                continue;
            }
            System.out.println(grid.toString());
        }
        //Game over
        if (game.getState() == TIE) {
            System.out.println("Game Over in a Tie!");
        } else {
            assert currentPlayer != null;
            System.out.println("Winner : " + currentPlayer.toString());
        }
    }
}
