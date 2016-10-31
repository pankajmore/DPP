/**
 * https://leetcode.com/contest/11/problems/arranging-coins/
 * Created by pankaj on 10/31/16.
 */
public class ArrangingCoins {
    public int arrangeCoins(int n) {
        int i = 0;
        while (n >= 0) {
            i += 1;
            n -= i;
        }
        return i - 1;
    }
}
