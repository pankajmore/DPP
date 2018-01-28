package dailycodingproblem;

import java.util.HashSet;
import java.util.Set;

/**
 * Given an integer k and a string s, find the length of the longest substring that contains at most
 * k distinct characters. For example, given s = "abcba" and k = 2, the longest substring with k
 * distinct characters is "bcb", so your function should return 3.
 */
class DCP13 {
    static int longestSubstringKDistinct(String s, int k) {
        if (s.length() <= k) {
            return s.length();
        }
        int best = k;
        for (int i = 0; i < s.length(); i++) {
            Set<Character> set = new HashSet<>();
            for (int j = i; j < s.length(); j++) {
                set.add(s.charAt(j));
                if (set.size() > k) {
                    break;
                } else {
                    best = Math.max(best, j - i + 1);
                }
            }
        }
        return best;
    }
}
