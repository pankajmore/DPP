package kConnectGame;

import kConnectGame.exceptions.BoardFullException;
import kConnectGame.exceptions.ColumnFullException;
import kConnectGame.exceptions.ColumnOutOfRangeException;

/**
 * Created by pankaj on 2/6/16.
 */
public class Grid {
    private final int numRows;
    private final int numCols;
    private final Player[][] _grid;
    private int numPlays;

    public Grid(int numRows, int numCols) {
        this.numRows = numRows;
        this.numCols = numCols;
        _grid = new Player[numRows][numCols];
        numPlays = 0;
    }

    /**
     * @param p      the player p that is playing
     * @param colIdx the column in which he wants to drop a coin
     * @throws ColumnOutOfRangeException if invalid column
     * @throws ColumnFullException       if column already full
     */
    public int insert(Player p, int colIdx) throws ColumnOutOfRangeException, ColumnFullException, BoardFullException {
        colIdx--;
        if (colIdx < 0 || colIdx >= numCols) {
            throw new ColumnOutOfRangeException("Column index : " + (colIdx + 1) + " out of range : [1," + numCols + "]");
        }
        for (int row = numRows - 1; row >= 0; row--) {
            if (_grid[row][colIdx] == null) {
                _grid[row][colIdx] = p;
                numPlays++;
                if (numPlays == numRows * numCols) throw new BoardFullException("Board is now full!");
                return row;
            }
        }
        throw new ColumnFullException("Column index : " + (colIdx + 1) + " is already full. Please try some other column!");
    }


    public int getNumCols() {
        return numCols;
    }


    public int getNumRows() {
        return numRows;
    }

    public Player getPlayerAt(int rowIdx, int colIdx) {
        return _grid[rowIdx][colIdx];
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numCols; col++) {
                if (_grid[row][col] == null)
                    sb.append("_" + " ");
                else
                    sb.append(_grid[row][col].toString() + " ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
