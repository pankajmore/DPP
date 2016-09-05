/**
 * https://leetcode.com/problems/utf-8-validation/
 * Created by pankaj on 9/5/16.
 */
public class UTF8Validation {
    public boolean validUtf8(int[] data) {
        int N = data.length;
        for (int i = 0; i < N; i++) {
            int x = whichEncoding(data[i]);
            if (x == -1) return false;
            while (x > 0 && i < N) {
                x--;
                if (x == 0) break;
                else i++;
                if (i == N || !valid(data[i])) return false;
            }
            if (x != 0) return false;
        }
        return true;
    }

    private int whichEncoding(int x) {
        if (((x >> 7) & 1) == 0) return 1;
        if (((x >> 6) & 1) == 0) return -1;
        if (((x >> 5) & 1) == 0) return 2;
        if (((x >> 4) & 1) == 0) return 3;
        if (((x >> 3) & 1) == 0) return 4;
        return -1;
    }

    private boolean valid(int x) {
        return ((x >> 7) & 1) == 1 && ((x >> 6) & 1) == 0;
    }
}
