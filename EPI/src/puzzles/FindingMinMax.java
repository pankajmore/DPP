package puzzles;

import java.util.List;

/**
 * Created by Pankaj on 1/5/16.
 */
public class FindingMinMax {
    /**
     * f(0) = 0
     * f(1) = 0
     * f(2) = 1
     * f(n) = f(n-2) + 3
     * f(n) = Math.ceil(3*n/2) - 2 (by recursion)
     *
     * @param A   the list of elements in which to find min and max
     * @param <T> the type of elements
     * @return the min and max in A
     */
    public static <T extends Comparable<T>> MinMax<T> findMinAndMax(List<T> A) {
        if (A.size() == 0) return null;
        if (A.size() == 1) return new MinMax<>(A.get(0), A.get(0));
        T min, max;
        if (A.get(0).compareTo(A.get(1)) < 0) {
            min = A.get(0);
            max = A.get(1);
        } else {
            min = A.get(1);
            max = A.get(0);
        }
        for (int i = 2; i + 1 < A.size(); i += 2) {
            T localMin, localMax;
            if (A.get(i).compareTo(A.get(i + 1)) < 0) {
                localMin = A.get(i);
                localMax = A.get(i + 1);
            } else {
                localMax = A.get(i);
                localMin = A.get(i + 1);
            }
            if (localMin.compareTo(min) < 0) min = localMin;
            if (localMax.compareTo(max) > 0) max = localMax;
        }
        if (A.size() % 2 != 0) {
            if (min.compareTo(A.get(A.size() - 1)) > 0) min = A.get(A.size() - 1);
            if (max.compareTo(A.get(A.size() - 1)) < 0) max = A.get(A.size() - 1);
        }
        return new MinMax<>(min, max);
    }


    public static class MinMax<T> {
        public final T min;
        public final T max;

        public MinMax(T min, T max) {
            this.min = min;
            this.max = max;
        }
    }
}
