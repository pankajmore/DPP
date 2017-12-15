/**
 * https://leetcode.com/problems/find-smallest-letter-greater-than-target/description/
 */
public class FindSmallestLetterGreaterThanTarget {
    public char nextGreatestLetter(char[] letters, char target) {
        int lo = 0, hi = letters.length - 1;
        if (target < letters[0] || target >= letters[hi]) return letters[0];
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (letters[mid] <= target) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return letters[hi];
    }
}
