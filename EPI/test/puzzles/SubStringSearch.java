package puzzles;

/**
 * Created by Pankaj on 11/23/15.
 */
public class SubStringSearch {
    /**
     * Search for the first occurrence of a substring
     * Time : O(s.length() * t.length())
     * Space : O(1)
     *
     * @param s string to search for
     * @param t string to search in
     * @return starting index of the first substring match
     * if one exists else -1
     */
    public static int search(String s, String t) {
        for (int i = 0; i + s.length() <= t.length(); i++)
            if (search(s, t, i)) return i;
        return -1;
    }

    private static boolean search(String s, String t, int start) {
        int i = 0;
        while (i < s.length() && start < t.length()) if (s.charAt(i++) != t.charAt(start++)) return false;
        return i >= s.length();
    }
}
