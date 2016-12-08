import java.util.Arrays;

/**
 * https://leetcode.com/problems/assign-cookies/
 * Created by pankaj on 14/11/16.
 */
public class AssignCookies {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int i = 0;
        for (int j = 0; j < s.length; j++) {
            if (g[i] <= s[j]) {
                i++;
            }
        }
        return i;
    }
}
