package puzzles;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pankaj on 8/22/15.
 */
public class LevenshteinDistance {

    public static int editDistance(String s1, String s2) {
        return editDistanceImpl(s1, s2, 1);
    }

    public static int editDistanceInsertAndDeleteOnly(String s1, String s2) {
        return editDistanceImpl(s1, s2, 2);
    }

    /**
     * Edit Distance between s1 of length m and s2 or length n
     * Time : O(m*n)
     * Space : O(min(m,n))
     *
     * @param s1
     * @param s2
     * @return
     */
    private static int editDistanceImpl(String s1, String s2, int costEdit) {
        if (s1.length() < s2.length()) {
            String tmp = s1;
            s1 = s2;
            s2 = tmp;
        }
        int m = s1.length(), n = s2.length();
        int A[] = new int[n + 1];
        for (int i = 0; i <= n; i++) A[i] = i;
        for (int i = 1; i <= m; i++) {
            int pp, prev = A[0];
            A[0] = i;
            for (int j = 1; j <= n; j++) {
                pp = A[j];
                A[j] = s1.charAt(i - 1) == s2.charAt(j - 1) ? prev : Math.min(1 + Math.min(A[j - 1], A[j]), prev + costEdit);
                prev = pp;
            }
        }
        return A[n];
    }

    /**
     * Compute the number of inserts + deletes + edits
     * needed to transform s1 to s2
     *
     * @param s1
     * @param s2
     * @return
     */
    public static int editDistanceRecursive(String s1, String s2) {
        if (s1.isEmpty()) return s2.length();
        if (s2.isEmpty()) return s1.length();

        return Math.min(Math.min(editDistance(s1.substring(0, s1.length() - 1), s2) + 1,
                        editDistance(s1, s2.substring(0, s2.length() - 1)) + 1),
                editDistance(s1.substring(0, s1.length() - 1), s2.substring(0, s2.length() - 1)) + (s1.charAt(s1.length() - 1) == s2.charAt(s2.length() - 1) ? 0 : 1));
    }

    //TODO
    public List<Integer> editDistanceOps(String s1, String s2) {
        return new ArrayList<>();
    }

    public enum Ops {
        Insert,
        Delete,
        Edit
    }
}
