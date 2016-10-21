/**
 * https://leetcode.com/problems/longest-repeating-character-replacement/
 * Created by pankaj on 10/20/16.
 */
public class LongestRepeatingCharacterReplacement {
    public int characterReplacement(String s, int k) {
        int N = s.length();
        int i = 0, j = 0, max = 0;
        int[] cnt = new int[26];
        while (j < N) {
            while (j < N && add(cnt, k, s.charAt(j++) - 'A')) {
                max = Math.max(max, j - i);
            }
            while (i < j && !remove(cnt, k, s.charAt(i++) - 'A')) ;
        }
        return max;
    }

    private boolean check(int[] cnt, int k) {
        int max = 0, sum = 0;
        for (int x : cnt) {
            max = Math.max(max, x);
            sum += x;
        }
        return sum - max <= k;
    }

    private boolean add(int[] cnt, int k, int c) {
        cnt[c]++;
        return check(cnt, k);
    }

    private boolean remove(int[] cnt, int k, int c) {
        cnt[c]--;
        return check(cnt, k);
    }
}
