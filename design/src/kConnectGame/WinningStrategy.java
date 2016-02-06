package kConnectGame;

/**
 * Created by pankaj on 2/6/16.
 */
public abstract class WinningStrategy {
    protected final int numConsecutiveSlots;

    public WinningStrategy(int numConsecutiveSlots) {
        this.numConsecutiveSlots = numConsecutiveSlots;
    }

    public abstract boolean won(Player p, Grid grid, int rowIdx, int colIdx);
}
