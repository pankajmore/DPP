package puzzles;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by pankaj on 1/19/16.
 * Find longest non-decreasing subsequents
 */
public class LongestNonDecreasingSubsequence {
    /**
     * Time : O(N^2)
     * Space : O(N)
     *
     * @param sequence a list of N integers
     * @return a non-decreasing subsequent of largest size
     */
    public static List<Integer> longestNonDecreasingSubSequence(List<Integer> sequence) {
        int N = sequence.size();
        int[] sequenceSize = new int[N], prev = new int[N];
        sequenceSize[0] = 1;
        prev[0] = -1;
        for (int i = 1; i < N; i++) {
            sequenceSize[i] = 1;
            prev[i] = -1;
            for (int j = 0; j < i; j++) {
                if (sequence.get(j) <= sequence.get(i)) {
                    if (sequenceSize[j] + 1 >= sequenceSize[i]) {
                        sequenceSize[i] = sequenceSize[j] + 1;
                        prev[i] = j;
                    }
                }
            }
        }
        int longestSequenceEndpoint = 0, longestSequenceSize = 1;
        for (int i = 1; i < N; i++) {
            if (sequenceSize[i] >= longestSequenceSize) {
                longestSequenceSize = sequenceSize[i];
                longestSequenceEndpoint = i;
            }
        }
        int j = longestSequenceEndpoint;
        List<Integer> longestNonDecreasingSubsequence = new ArrayList<>();
        while (j != -1) {
            longestNonDecreasingSubsequence.add(sequence.get(j));
            j = prev[j];
        }
        assert longestNonDecreasingSubsequence.size() == longestSequenceSize;
        Collections.reverse(longestNonDecreasingSubsequence);
        return longestNonDecreasingSubsequence;
    }
}
