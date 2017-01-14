import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/isomorphic-strings/
 * Created by pankaj on 14/01/17.
 */
public class IsomorphicStrings {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> map = new HashMap<>(), rmap = new HashMap<>();
        int N = s.length();
        for (int i = 0; i < N; i++) {
            char x = s.charAt(i);
            char y = t.charAt(i);
            if (!map.containsKey(x)) {
                map.put(x, y);
            }
            if (!rmap.containsKey(y)) {
                rmap.put(y, x);
            }
            if (y != map.get(x) || x != rmap.get(y)) return false;
        }
        return true;
    }
}
