package puzzles;

import java.util.List;

/**
 * Created by Pankaj on 8/8/15.
 */
public class CountInversions {
    public static int countInversions(List<Integer> A) {
        return countInversionsImpl(A, 0, A.size() - 1);
    }

    private static int countInversionsImpl(List<Integer> A, int i, int j) {
        if (i == j) return 0;
        int m = (i + j) / 2, c = 0;
        c += countInversionsImpl(A, i, m);
        c += countInversionsImpl(A, m + 1, j);
        c += countMerge(A, i, m + 1);
        return c;
    }

    private static int countMerge(List<Integer> A, int i, int j) {
        int M = j - 1;
        int N = A.size();
        int mid = j;
        int c = 0;
        while (i < M && j < N) {
            if (A.get(i) <= A.get(j)) {
                i++;
                c += j - mid;
            } else {
                j++;
            }
        }
        while (i < M) {
            i++;
            c += j - mid;
        }
        while (j < N) j++;
        return c;
    }

    public static int countInversionsTrivial(List<Integer> A) {
        int c = 0;
        for (int i = 0; i < A.size(); i++) {
            for (int j = i + 1; j < A.size(); j++) {
                if (A.get(i) > A.get(j))
                    c++;
            }
        }
        return c;
    }
}
