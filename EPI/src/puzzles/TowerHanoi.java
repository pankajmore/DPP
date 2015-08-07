package puzzles;

/**
 * Created by Pankaj on 8/7/15.
 */
public class TowerHanoi {
    static int numSteps = 0;

    public static void moveDisks(int n, String src, String dest, String interim) {
        if (n == 0) return;
        moveDisks(n - 1, src, interim, dest);
        System.out.println(String.format("%d : %s -> %s", n, src, dest));
        numSteps++;
        moveDisks(n - 1, interim, dest, src);
    }

    public static void main(String[] args) {
        moveDisks(3, "P1", "P2", "P3");
        assert (numSteps == Math.pow(2, 3) - 1);
    }
}
