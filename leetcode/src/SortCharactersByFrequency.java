import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/sort-characters-by-frequency
 * Created by pankaj on 02/03/17.
 */
public class SortCharactersByFrequency {
    public String frequencySort(String s) {
        int N = s.length();
        int[] freq = new int[256];
        List<List<Character>> buckets = new ArrayList<>();
        buckets.add(new ArrayList<>());
        for (int i = 0; i < N; i++) {
            char c = s.charAt(i);
            freq[c]++;
            buckets.add(new ArrayList<>());
        }
        for (char c = 0; c < 256; c++) {
            buckets.get(freq[c]).add(c);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = N; i >= 0; i--) {
            for (char c : buckets.get(i)) {
                for (int j = 0; j < i; j++) sb.append(c);
            }
        }
        return sb.toString();
    }
}
