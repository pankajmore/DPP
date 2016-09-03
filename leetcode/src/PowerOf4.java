/**
 * https://leetcode.com/problems/power-of-four/
 * Created by pankaj on 9/3/16.
 */
public class PowerOf4 {
    public boolean isPowerOfFour(int num) {
        return num > 0 && (num & num - 1) == 0 && (num & 0xaaaaaaaa) == 0;
    }
}
