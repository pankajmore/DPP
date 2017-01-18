import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/word-pattern/
 * Created by pankaj on 18/01/17.
 */
public class WordPattern {
    public boolean wordPattern(String pattern, String str) {
        int M = pattern.length(), N = str.length();
        StringBuilder sb = new StringBuilder();
        Map<Character, String> map = new HashMap<>();
        Map<String, Character> rmap = new HashMap<>();
        int idx = 0;
        for (int i = 0; i <= N; i++) {
            if (i == N || str.charAt(i) == ' ') {
                if (idx >= M) return false;
                char k = pattern.charAt(idx++);
                String s = sb.toString();
                map.putIfAbsent(k, s);
                rmap.putIfAbsent(s, k);
                if (!map.get(k).equals(s) || !rmap.get(s).equals(k)) return false;
                sb = new StringBuilder();
            } else {
                sb.append(str.charAt(i));
            }
        }
        return idx == M;
    }
}
