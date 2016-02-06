package kConnectGame;

/**
 * Created by pankaj on 2/6/16.
 */
public class HorizontalWinningStrategy extends WinningStrategy {

    public HorizontalWinningStrategy(int numConsecutiveSlots) {
        super(numConsecutiveSlots);
    }

    @Override
    public boolean won(Player p, Grid grid, int rowIdx, int colIdx) {
        colIdx--;
        int numCols = grid.getNumCols();
        int leftIdx = colIdx, rightIdx = colIdx;
        for (int col = colIdx; col >= 0; col--) {
            if (p.equals(grid.getPlayerAt(rowIdx, col))) leftIdx = col;
            else break;
        }
        for (int col = colIdx; col < numCols; col++) {
            if (p.equals(grid.getPlayerAt(rowIdx, col))) rightIdx = col;
            else break;
        }
        return rightIdx - leftIdx + 1 >= numConsecutiveSlots;
    }
}
