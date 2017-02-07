/**
 * Created by pankaj on 07/02/17.
 */
public class ReverseBits {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int r = 0;
        for (int i = 0; i < 32; i++) {
            r <<= 1;
            r |= (n & 1);
            n >>= 1;
        }
        return r;
    }
}