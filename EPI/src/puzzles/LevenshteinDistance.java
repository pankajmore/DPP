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

    public static List<Ops> editDistanceOps(String s1, String s2) {
        if (s1.length() > s2.length()) {
            String tmp = s1;
            s1 = s2;
            s2 = tmp;
        }
        int m = s1.length(), n = s2.length();
        int A[] = new int[n + 1];
        List<List<Ops>> ls = new ArrayList<>();
        for (int i = 0; i <= n; i++) ls.add(new ArrayList<>());
        A[0] = 0;
        for (int i = 1; i <= n; i++) {
            A[i] = i;
            List<Ops> l = new ArrayList<>(ls.get(i - 1));
            l.add(Ops.Insert);
            ls.set(i, l);
        }
        for (int i = 1; i <= m; i++) {
            int pp, prev = A[0];
            List<Ops> ppL, prevL = new ArrayList<>(ls.get(0));
            List<Ops> iL = new ArrayList<>(ls.get(0));
            iL.add(Ops.Insert);
            ls.set(0, iL);
            for (int j = 1; j <= n; j++) {
                pp = A[j];
                ppL = new ArrayList<>(ls.get(j));
                List<Ops> l = new ArrayList<>();
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    l.addAll(prevL);
                    A[j] = prev;
                } else {
                    int min = Math.min(Math.min(A[j - 1], A[j]), prev);
                    A[j] = 1 + min;
                    if (min == prev) {
                        l.addAll(prevL);
                        l.add(Ops.Edit);
                    } else if (min == A[j - 1]) {
                        l.addAll(ls.get(j - 1));
                        l.add(Ops.Insert);
                    } else {
                        l.addAll(ls.get(j));
                        l.add(Ops.Delete);
                    }
                }
                prev = pp;
                prevL = ppL;
                ls.set(j, l);
            }
        }
        return ls.get(n);
    }

    public enum Ops {
        Insert,
        Delete,
        Edit
    }
}
