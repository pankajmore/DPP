import com.sun.istack.internal.NotNull;

import java.util.function.Function;

/**
 * http://jeffe.cs.illinois.edu/teaching/algorithms/notes/05-dynprog.pdf
 * Page - 22, Q9
 * Created by pankaj on 13/11/16.
 */
public class Q9 {
    /**
     * Time : O(N^2 * K)
     * Space: O(N)
     *
     * @param s       string of size N
     * @param quality takes O(K) time for input of size K
     * @return the number of partitions s.t total quality is maximum (ties are broken by minimizing #partitions)
     */
    public static int maxQualityDecomposition(@NotNull String s, Function<String, Integer> quality) {
        int N = s.length();
        if (N == 0) return 0;
        int[] maxQuality = new int[N];
        int[] numStrings = new int[N];
        maxQuality[0] = quality.apply(s.substring(0, 1));
        numStrings[0] = 1;
        for (int i = 1; i < N; i++) {
            maxQuality[i] = quality.apply(s.substring(0, i + 1));
            numStrings[i] = 1;
            for (int j = 0; j < i; j++) {
                int currentQuality = maxQuality[j] + quality.apply(s.substring(j + 1, i + 1));
                if (maxQuality[i] < currentQuality ||
                        (maxQuality[i] == currentQuality && numStrings[i] > numStrings[j] + 1)) {
                    maxQuality[i] = currentQuality;
                    numStrings[i] = numStrings[j] + 1;
                }
            }
        }
        return numStrings[N - 1];
    }
}
