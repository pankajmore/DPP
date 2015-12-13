package puzzles;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pankaj on 12/10/15.
 */
public class GrayCode {
    /**
     * Returns a n bit gray code sequence
     * <p>
     * Time : O(2^n)
     * Space : O(2^n)
     *
     * @param n the number of bits
     * @return one possible gray code sequence
     */
    public static List<Integer> grayCode(int n) {
        List<Integer> grayCodes = new ArrayList<>();
        if (n == 0) return grayCodes;
        grayCodes.add(0);
        grayCodes.add(1);
        for (int i = 2; i <= n; i++) {
            for (int j = grayCodes.size() - 1; j >= 0; j--) grayCodes.add(grayCodes.get(j) + (1 << i - 1));
        }
        return grayCodes;
    }
}
