package puzzles;

import puzzles.SubseqCover.SubArray;

import java.util.List;

/**
 * Created by pankaj on 4/14/16.
 */
public class LongestIncreasingSubarray {
    /**
     * Time : O(N)
     * Space: O(1)
     *
     * @param A list of size N
     * @return the longest increasing sub-array
     */
    public static SubArray findLongestIncreasingSubarray(List<Integer> A) {
        int start = 0, end = 0, N = A.size();
        if (N == 0) return new SubArray(-1, -1);
        for (int i = 0, j = 1; j < N; j++) {
            if (A.get(j - 1) < A.get(j)) {
                if (end - start < j - i) {
                    start = i;
                    end = j;
                }
            } else {
                i = j;
            }
        }
        return new SubArray(start, end);
    }

    /**
     * Time : O(N * N)
     * Space: O(1)
     *
     * @param A list of size N
     * @return the longest increasing sub-array
     */
    public static SubArray findLongestIncreasingSubarray1(List<Integer> A) {
        int start = 0, end = 0, N = A.size();
        if (N == 0) return new SubArray(-1, -1);
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (A.get(j - 1) >= A.get(j)) break;
                if (A.get(j - 1) < A.get(j)) {
                    if (end - start < j - i) {
                        start = i;
                        end = j;
                    }
                }
            }
        }
        return new SubArray(start, end);
    }

    /**
     * Time : O(N), best case -> O(Max(N/L, L))
     * Space: O(1)
     *
     * @param A list of size N
     * @return the longest increasing sub-array
     */
    public static SubArray findLongestIncreasingSubarray2(List<Integer> A) {
        int N = A.size();
        if (N == 0) return new SubArray(-1, -1);
        SubArray ans = new SubArray(0, 0);
        int i = 0, maxLength = 1;
        while (i < N - maxLength) {
            boolean skippable = false;
            for (int j = i + maxLength; j > i; j--) {
                if (A.get(j - 1) >= A.get(j)) {
                    skippable = true;
                    i = j;
                    break;
                }
            }
            if (!skippable) {
                i += maxLength;
                while (i < N && A.get(i - 1) < A.get(i)) {
                    i++;
                    maxLength++;
                }
                ans = new SubArray(i - maxLength, i - 1);
            }
        }
        return ans;
    }
}
