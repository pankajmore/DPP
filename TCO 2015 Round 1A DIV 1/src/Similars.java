import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Similars {

    public int maxsim(int L, int R) {
        int best = 0;
        Map<Integer, Integer> cntMap = new HashMap<>();
        for (int a = L; a <= R; a++) {
            int aa = bitMask(a);
            if (!cntMap.containsKey(aa)) cntMap.put(aa, 0);
            cntMap.put(aa, cntMap.get(aa) + 1);
        }
        for (Integer bitMask : cntMap.keySet()) {
            if (cntMap.get(bitMask) > 1) best = Math.max(best, cntOnes(bitMask));
            else for (Integer bitMask1 : cntMap.keySet()) {
                if (!Objects.equals(bitMask, bitMask1))
                    best = Math.max(best, cntOnes(bitMask & bitMask1));
            }
        }
        return best;
    }

    private int cntOnes(int x) {
        int c = 0;
        while (x > 0) {
            x = x & (x - 1);
            c++;
        }
        return c;
    }

    private int bitMask(int x) {
        int res = 0;
        while (x > 0) {
            int d = x % 10;
            x /= 10;
            res |= 1 << d;
        }
        return res;
    }
}
