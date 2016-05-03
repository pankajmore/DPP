package puzzles;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pankaj on 5/3/16.
 */
public class EliasGammaEncoding {
    public static String encode(List<Integer> A) {
        StringBuilder sb = new StringBuilder();
        for (int x : A) sb.append(encode(x));
        return sb.toString();
    }

    public static String encode(int x) {
        if (x <= 0) throw new IllegalArgumentException("Cannot encode non-positive integer : " + x);
        StringBuilder sb = new StringBuilder();
        while (x > 0) {
            sb.append(x % 2);
            x >>>= 1;
        }
        int N = sb.length();
        for (int i = 1; i < N; i++) sb.append(0);
        return sb.reverse().toString();
    }

    public static List<Integer> decode(String s) {
        if (s.isEmpty()) throw new IllegalArgumentException("Invalid string: " + s);
        int i = 0, N = s.length();
        List<Integer> A = new ArrayList<>();
        while (i < N) {
            int x = 0, c = 0;
            for (; i < N && s.charAt(i) == '0'; i++) c++;
            if (N - i < c + 1) throw new IllegalArgumentException("Incorrect encoding: " + s);
            for (; c >= 0 && i < N; c--, i++) x = (x << 1) + s.charAt(i) - '0';
            A.add(x);
        }
        return A;
    }

    public static int decode1(String s) {
        if (s.isEmpty()) throw new IllegalArgumentException("Invalid string: " + s);
        int x = 0, c = 0, i = 0, N = s.length();
        for (; i < N && s.charAt(i) == '0'; i++) c++;
        if (N != 2 * c + 1) throw new IllegalArgumentException("Incorrect encoding: " + s);
        for (; i < N; i++) x = (x << 1) + s.charAt(i) - '0';
        return x;
    }
}
