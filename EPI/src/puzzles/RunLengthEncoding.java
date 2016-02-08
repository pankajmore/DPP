package puzzles;

/**
 * Created by pankaj on 2/8/16.
 */
public class RunLengthEncoding {
    public static String encode(String s) {
        StringBuilder sb = new StringBuilder();
        if (s.isEmpty()) return sb.toString();
        int count = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) != s.charAt(i - 1)) {
                sb.append(count);
                sb.append(s.charAt(i - 1));
                count = 1;
            } else {
                count++;
            }
        }
        sb.append(count);
        sb.append(s.charAt(s.length() - 1));
        return sb.toString();
    }

    public static String decode(String s) {
        if (s.isEmpty()) return "";
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) count = count * 10 + c - '0';
            else for (; count > 0; count--) sb.append(c);
        }
        return sb.toString();
    }
}
