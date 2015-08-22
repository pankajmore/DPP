package puzzles;

/**
 * Created by Pankaj on 8/22/15.
 */
public class LevenshteinDistance {
    /**
     * Compute the number of inserts + deletes + edits
     * needed to transform s1 to s2
     *
     * @param s1
     * @param s2
     * @return
     */
    public static int editDistance(String s1, String s2) {
        if (s1.isEmpty()) return s2.length();
        if (s2.isEmpty()) return s1.length();

        return Math.min(Math.min(editDistance(s1.substring(0, s1.length() - 1), s2) + 1,
                        editDistance(s1, s2.substring(0, s2.length() - 1)) + 1),
                editDistance(s1.substring(0, s1.length() - 1), s2.substring(0, s2.length() - 1)) + (s1.charAt(s1.length() - 1) == s2.charAt(s2.length() - 1) ? 0 : 1));
    }
}
