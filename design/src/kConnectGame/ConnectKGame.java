package kConnectGame;

import kConnectGame.exceptions.BoardFullException;
import kConnectGame.exceptions.ColumnFullException;
import kConnectGame.exceptions.ColumnOutOfRangeException;
import kConnectGame.exceptions.IncorrectTurnException;

import java.util.List;

/**
 * Created by pankaj on 2/6/16.
 */
public class ConnectKGame {
    private final Grid _grid;
    private final List<Player> _players;
    private final List<WinningStrategy> _strategies;
    private int turn;
    private GameState _state;

    public ConnectKGame(Grid grid, List<Player> players, List<WinningStrategy> strategies) {
        _grid = grid;
        _players = players;
        _strategies = strategies;
        _state = GameState.RUNNING;
        turn = 0;
    }

    public GameState play(Player p, int colIdx) throws ColumnFullException, ColumnOutOfRangeException, IncorrectTurnException {
        if (!checkCorrectTurn(p)) throw new IncorrectTurnException("Not your turn!");
        int rowIdx = 0;
        try {
            rowIdx = _grid.insert(p, colIdx);
        } catch (BoardFullException e) {
            e.printStackTrace();
            if (checkIfPlayerWins(p, rowIdx, colIdx))
                return _state = GameState.WIN;
            else
                return _state = GameState.TIE;
        }
        if (checkIfPlayerWins(p, rowIdx, colIdx)) return _state = GameState.WIN;
        // game is still on!
        updateTurn();
        return _state = GameState.RUNNING;
    }

    private boolean checkIfPlayerWins(Player p, int rowIdx, int colIdx) {
        for (WinningStrategy strategy : _strategies) {
            if (strategy.won(p, _grid, rowIdx, colIdx)) {
                return true;
            }
        }
        return false;
    }

    private boolean checkCorrectTurn(Player p) {
        return p.equals(_players.get(turn));
    }

    private void updateTurn() {
        turn = (turn + 1) % _players.size();
    }

    public GameState getState() {
        return _state;
    }

    public enum GameState {
        WIN, TIE, RUNNING
    }

}
