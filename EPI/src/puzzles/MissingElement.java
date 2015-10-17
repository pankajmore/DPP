package puzzles;

import java.util.List;

/**
 * Created by Pankaj on 10/17/15.
 */
public class MissingElement {
    private static final int size = 1 << 16;

    public static int findMissingElement(List<Integer> ls) {
        int[] msbs = new int[size];
        int[] lsbs = new int[size];
        int msb = 0, lsb = 0;
        for (int x : ls) msbs[x >> 16]++;
        for (int i = 0; i < size; i++)
            if (msbs[i] < size) {
                msb = i;
                break;
            }
        for (int x : ls)
            if (x >> 16 == msb) {
                lsbs[(1 << 16 - 1) & x]++;
            }
        for (int i = 0; i < size; i++)
            if (lsbs[i] == 0) {
                lsb = i;
                break;
            }
        return msb << 16 | lsb;
    }
}
