package kConnectGame;

/**
 * Created by pankaj on 2/6/16.
 */
public class VerticalWinningStrategy extends WinningStrategy {

    public VerticalWinningStrategy(int numConsecutiveSlots) {
        super(numConsecutiveSlots);
    }

    @Override
    public boolean won(Player p, Grid grid, int rowIdx, int colIdx) {
        colIdx--;
        int numRows = grid.getNumRows();
        int bottomIdx = rowIdx, topIdx = rowIdx;
        for (int row = rowIdx - 1; row >= 0; row--) {
            if (p.equals(grid.getPlayerAt(row, colIdx))) bottomIdx = row;
            else break;
        }
        for (int row = rowIdx + 1; row < numRows; row++) {
            if (p.equals(grid.getPlayerAt(row, colIdx))) topIdx = row;
            else break;
        }
        return topIdx - bottomIdx + 1 >= numConsecutiveSlots;
    }
}
