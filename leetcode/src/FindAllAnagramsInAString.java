import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/find-all-anagrams-in-a-string/
 * Created by pankaj on 10/24/16.
 */
public class FindAllAnagramsInAString {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> l = new ArrayList<>();
        int[] cnt = new int[26];
        int[] actual = new int[26];
        if(s == null) return l;
        int M = s.length(), N = p.length();
        if(N > M) return l;
        for(int i = 0; i < N; i++) {
            cnt[s.charAt(i) - 'a']++;
            actual[p.charAt(i) - 'a']++;
        }
        for(int i = N; i < M; i++) {
            if(check(cnt, actual)) l.add(i - N);
            cnt[s.charAt(i - N) - 'a']--;
            cnt[s.charAt(i) - 'a']++;
        }
        if(check(cnt, actual)) l.add(M - N);
        return l;
    }

    boolean check(int[] cnt, int[] actual) {
        for(int i = 0; i < 26; i++)
            if(cnt[i] != actual[i])
                return false;
        return true;
    }
}
