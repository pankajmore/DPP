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
        if (i >= j) return 0;
        int m = (i + j) / 2, c = 0;
        c += countInversionsImpl(A, i, m);
        c += countInversionsImpl(A, m + 1, j);
        c += countMerge(A, i, j);
        return c;
    }

    private static int countMerge(List<Integer> A, int l, int h) {
        int M = (l + h) / 2;
        int N = h;
        int i = 0, j = M;
        int c = 0;
        while (i <= M && j <= N) {
            if (A.get(i) <= A.get(j)) {
                i++;
                c += j - M;
            } else {
                int temp = A.get(i);
                A.set(i, A.get(j));
                A.set(j, temp);
                j++;
            }
        }
        while (i <= M) {
            i++;
            c += j - M;
        }
        while (j <= N) j++;
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
