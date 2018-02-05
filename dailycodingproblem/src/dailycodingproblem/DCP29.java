package dailycodingproblem;

/**
 * Run-length encoding is a fast and simple method of encoding strings. The basic idea is to
 * represent repeated successive characters as a single count and character. For example, the string
 * "AAAABBBCCDAA" would be encoded as "4A3B2C1D2A".
 * <p>
 * <p>Implement run-length encoding and decoding. You can assume the string to be encoded have no
 * digits and consists solely of alphabetic characters. You can assume the string to be decoded is
 * valid.
 */
class DCP29 {
    static String encode(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        for (int i = 0; i <= s.length(); i++) {
            if ((i != s.length()) && (i == 0 || s.charAt(i) == s.charAt(i - 1))) {
                cnt++;
            } else {
                sb.append(cnt);
                sb.append(s.charAt(i - 1));
                cnt = 1;
            }
        }
        return sb.toString();
    }

    static String decode(String s) {
        if (s == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        for (int i = 0; i <= s.length(); i++) {
            if (i != s.length() && Character.isDigit(s.charAt(i))) {
                cnt = cnt * 10 + Character.digit(s.charAt(i), 10);
            } else {
                while (cnt-- > 0) {
                    sb.append(s.charAt(i));
                }
                cnt = 0;
            }
        }
        return sb.toString();
    }
}
