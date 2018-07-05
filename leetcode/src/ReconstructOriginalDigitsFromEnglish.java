/**
 * https://leetcode.com/problems/reconstruct-original-digits-from-english/ Created by pankaj on
 * 10/18/16.
 */
public class ReconstructOriginalDigitsFromEnglish {
  public String originalDigits(String s) {
    int[] A = new int[26];
    int[] cnt = new int[10];
    for (char c : s.toCharArray()) A[c - 'a']++;
    String[] digits =
        new String[] {
          "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten"
        };
    int[] order = new int[] {0, 2, 4, 1, 3, 6, 7, 5, 8, 9};
    char[] uniq = new char[] {'z', 'w', 'u', 'o', 'r', 'x', 's', 'v', 'g', 'n'};
    for (int i = 0; i < 10; i++) {
      int d = order[i];
      char u = uniq[i];
      while (A[u - 'a'] > 0) {
        for (char c : digits[d].toCharArray()) {
          A[c - 'a']--;
        }
        cnt[d]++;
      }
    }
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < 10; i++) {
      while (cnt[i]-- > 0) sb.append(i);
    }
    return sb.toString();
  }
}
