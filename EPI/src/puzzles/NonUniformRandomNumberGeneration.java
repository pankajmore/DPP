package puzzles;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by pankaj on 4/19/16.
 */
public class NonUniformRandomNumberGeneration {
    /**
     * @param values        the set of values to choose from
     * @param probabilities individual probability for selecting each value
     * @return one of the possible values v_i with probability p_i
     */
    public static int nonUniformRandomNumberGeneration(List<Integer> values, List<Double> probabilities) {
        List<Double> A = new ArrayList<>();
        for (int i = 0; i < probabilities.size(); i++) {
            A.add(probabilities.get(i) + (i == 0 ? 0 : A.get(i - 1)));
        }
        double r = new Random().nextDouble();
        return values.get(search(A, r));
    }

    private static int search(List<Double> A, double x) {
        int lo = 0, hi = A.size() - 1, mid, index = hi;
        while (lo <= hi) {
            mid = (lo + hi) / 2;
            if (A.get(mid) > x) {
                index = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return index;
    }
}
