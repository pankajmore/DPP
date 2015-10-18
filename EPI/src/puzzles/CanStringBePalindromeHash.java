package puzzles;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Pankaj on 10/18/15.
 */
public class CanStringBePalindromeHash {
    public static boolean canStringBeAPalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (Character c : s.toCharArray()) {
            if (!map.containsKey(c))
                map.put(c, 0);
            map.put(c, map.get(c) + 1);
        }
        int numOdds = 0;
        for (Integer i : map.values()) if (i % 2 != 0) numOdds++;
        if (s.length() % 2 == 0) return numOdds == 0;
        else return numOdds == 1;
    }
}
