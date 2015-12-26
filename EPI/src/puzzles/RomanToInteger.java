package puzzles;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Pankaj on 12/26/15.
 */
public class RomanToInteger {
    public static int romanToInteger(String s) {
        Map<Character, Integer> T = new HashMap<Character, Integer>() {
            {
                put('I', 1);
                put('V', 5);
                put('X', 10);
                put('L', 50);
                put('C', 100);
                put('D', 500);
                put('M', 1000);
            }
        };
        int x = T.get(s.charAt(s.length() - 1));
        for (int i = s.length() - 2; i >= 0; i--) {
            if (T.get(s.charAt(i)) < T.get(s.charAt(i + 1))) x -= T.get(s.charAt(i));
            else x += T.get(s.charAt(i));
        }
        return x;
    }
}
