/**
 * https://leetcode.com/problems/find-the-difference/
 * https://leetcode.com/contest/2/problems/find-the-difference/
 * Created by pankaj on 8/28/16.
 */
public class FindTheDifference {
    public char findTheDifference(String s, String t) {
        char d = 0;
        for (int i = 0; i < s.length(); i++) {
            d ^= s.charAt(i) ^ t.charAt(i);
        }
        d ^= t.charAt(t.length() - 1);
        return d;
    }
}
