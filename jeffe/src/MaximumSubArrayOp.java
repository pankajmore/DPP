import java.util.List;

/**
 * http://jeffe.cs.illinois.edu/teaching/algorithms/notes/05-dynprog.pdf
 * Page - 18, Q2
 * Created by pankaj on 9/15/16.
 */
public class MaximumSubArrayOp {
    public static double maximumSubArraySum(List<Double> A) {
        double max = 0, maxEndingHere = 0;
        for (double x : A) {
            maxEndingHere = Math.max(maxEndingHere + x, x);
            max = Math.max(maxEndingHere, max);
        }
        return max;
    }

    public static double maximumSubArrayProduct(List<Double> A) {
        double max = 1, maxEndingHere = 1, minEndingHere = 1;
        for (double x : A) {
            double temp = Math.max(x, Math.max(maxEndingHere * x, minEndingHere * x));
            minEndingHere = Math.min(x, Math.min(maxEndingHere * x, minEndingHere * x));
            maxEndingHere = temp;
            max = Math.max(max, maxEndingHere);
        }
        return max;
    }
}
