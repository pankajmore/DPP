package puzzles;

/**
 * Created by Pankaj on 8/24/15.
 */
public class LongestCommonSubsequence {
    /**
     * Using edit distance between s1 (length m) and s2 (length n)
     * Time : O(m*n)
     * Space : O(min(m,n))
     *
     * @param s1
     * @param s2
     * @return
     */
    public static int usingEditDistance(String s1, String s2) {
        return (s1.length() + s2.length() - LevenshteinDistance.editDistanceInsertAndDeleteOnly(s1, s2)) / 2;
    }
}
