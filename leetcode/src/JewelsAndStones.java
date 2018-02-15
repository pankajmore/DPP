import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/jewels-and-stones/
 */
class JewelsAndStones {
    int numJewelsInStones(String J, String S) {
        Set<Character> jewels = new HashSet<>();
        for (char c : J.toCharArray()) {
            jewels.add(c);
        }
        int cnt = 0;
        for (char c : S.toCharArray()) {
            if (jewels.contains(c)) {
                cnt++;
            }
        }
        return cnt;
    }
}
