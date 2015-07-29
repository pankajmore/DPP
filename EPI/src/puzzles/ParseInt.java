package puzzles;

import java.io.PrintStream;
import java.util.Scanner;

/**
 * Created by pankajm on 6/3/15.
 */
public class ParseInt {
    public static int parseInt(String s) throws Exception {
        int N = s.length();
        int x = 0;
        int p = 1;
        for (int i = N - 1; i >= 0; i--) {
            int d = s.charAt(i) - '0';
            if (d >= 0 && d <= 9) {
                x += p * d;
                p *= 10;
            } else if (i != 0) {
                throw new Exception("Not an integer!");
            }
        }
        if (s.charAt(0) == '-')
            x *= -1;
        return x;
    }

    public static void main(String[] args) throws Exception {
        PrintStream out = new PrintStream(System.out);
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        out.println(ParseInt.parseInt(s));
    }
}
