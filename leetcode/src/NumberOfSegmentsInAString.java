/**
 * https://leetcode.com/problems/number-of-segments-in-a-string/
 * Created by pankaj on 04/12/16.
 */
public class NumberOfSegmentsInAString {
    public int countSegments(String s) {
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ' ' && (i == 0 || s.charAt(i - 1) == ' '))
                cnt++;
        }
        return cnt;
    }
}
