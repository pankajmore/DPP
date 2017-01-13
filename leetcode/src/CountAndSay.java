/**
 * https://leetcode.com/problems/count-and-say/
 * Created by pankaj on 13/01/17.
 */
public class CountAndSay {
    public String countAndSay(int n) {
        String s = "1";
        StringBuilder sb;
        for (int i = 1; i < n; i++) {
            sb = new StringBuilder();
            int cnt = 1, x = s.charAt(0) - '0';
            for (int j = 1; j < s.length(); j++) {
                int y = s.charAt(j) - '0';
                if (x == y) cnt++;
                else {
                    sb.append(cnt).append(x);
                    cnt = 1;
                    x = y;
                }
            }
            sb.append(cnt).append(x);
            s = sb.toString();
        }
        return s;
    }
}
