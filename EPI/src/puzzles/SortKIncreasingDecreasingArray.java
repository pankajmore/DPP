package puzzles;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static puzzles.MergeNSortedLists.mergeNSortedLists;

/**
 * Created by pankaj on 3/5/16.
 */
public class SortKIncreasingDecreasingArray {
    /**
     * Time : O(NlogK)
     * Space: O(K) extra
     *
     * @param A a k-increasing-decreasing list of size N
     * @return returns a sorted copy of A
     */
    public static List<Integer> sortKIncreasingDecreasingArray(List<Integer> A) {
        int N = A.size();
        List<List<Integer>> subArrays = new ArrayList<>();
        SubArrayType subArrayType = SubArrayType.INCREASING;
        int startIdx = 0;
        for (int i = 1; i <= N; i++) {
            if (i == N || A.get(i - 1) < A.get(i) && subArrayType == SubArrayType.DECREASING
                    || A.get(i - 1) >= A.get(i) && subArrayType == SubArrayType.INCREASING) {
                List<Integer> subArray = A.subList(startIdx, i);
                if (subArrayType == SubArrayType.DECREASING) Collections.reverse(subArray);
                subArrays.add(subArray);
                startIdx = i;
                subArrayType = subArrayType == SubArrayType.INCREASING ? SubArrayType.DECREASING :
                        SubArrayType.INCREASING;
            }
        }
        return mergeNSortedLists(subArrays);
    }

    private enum SubArrayType {
        INCREASING,
        DECREASING
    }
}
