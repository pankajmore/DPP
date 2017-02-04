import java.util.*;

/**
 * https://leetcode.com/contest/leetcode-weekly-contest-18a/problems/keyboard-row/
 * Created by pankaj on 04/02/17.
 */
public class KeyboardRow {
    public String[] findWords(String[] words) {
        List<String> l = new ArrayList<>();
        for (String word : words) {
            if (oneRow(word)) l.add(word);
        }
        String[] res = new String[l.size()];
        for (int i = 0; i < res.length; i++) res[i] = l.get(i);
        return res;
    }

    private boolean oneRow(String s) {
        String[] rows = new String[]{"qwertyuiop", "asdfghjkl", "zxcvbnm"};
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < 2; i++) {
            for (char c : rows[i].toCharArray()) map.put(c, i);
        }
        Set<Integer> r = new HashSet<>();
        for (char c : s.toCharArray()) {
            c = Character.toLowerCase(c);
            r.add(map.get(c));
        }
        return r.size() <= 1;
    }
}
