/**
 * https://leetcode.com/problems/longest-common-prefix/
 * Created by pankaj on 02/02/17.
 */
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        StringBuilder sb = new StringBuilder();
        for (int idx = 0; ; idx++) {
            for (int i = 0; i < strs.length; i++) {
                String s = strs[i];
                if (idx >= s.length() || (i > 0 && s.charAt(idx) != strs[i - 1].charAt(idx))) {
                    return sb.toString();
                }
            }
            sb.append(strs[0].charAt(idx));
        }
    }
}
