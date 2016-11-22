package dp;

import com.sun.istack.internal.NotNull;

import java.util.*;

/**
 * http://jeffe.cs.illinois.edu/teaching/algorithms/notes/05-dynprog.pdf
 * Page - 22, Q10
 * Created by pankaj on 15/11/16.
 */
public class Q10 {
    public static int largestNonIntersectingSubset(@NotNull List<Integer> A, @NotNull List<Integer> B) {
        assert A.size() == B.size();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < A.size(); i++) {
            map.put(B.get(i), A.get(i));
        }
        Collections.sort(B, Comparator.comparing(map::get));
        return Q3.longestMonotonicSubsequence(B, true);
    }

    public static int largestIntersectingSubset(@NotNull List<Integer> A, @NotNull List<Integer> B) {
        assert A.size() == B.size();
        if (A.size() == 0) return 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < A.size(); i++) {
            map.put(B.get(i), A.get(i));
        }
        Collections.sort(B, Comparator.comparing(map::get));
        int maxCnt = 1, cnt = 1, minY = B.get(0);
        for (int i = 1; i < B.size(); i++) {
            if (B.get(i) < minY) {
                cnt++;
                minY = Math.min(minY, B.get(i));
            } else {
                maxCnt = Math.max(maxCnt, cnt);
                minY = B.get(i);
                cnt = 1;
            }
        }
        maxCnt = Math.max(maxCnt, cnt);
        return maxCnt;
    }
}
