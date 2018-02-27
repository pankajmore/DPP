/** https://leetcode.com/problems/custom-sort-string/description/ */
class CustomSortString {
  String customSortString(String S, String T) {
    int[] cnt = new int[26];
    for (char c : T.toCharArray()) {
      cnt[c - 'a']++;
    }
    StringBuilder sb = new StringBuilder();
    for (char c : S.toCharArray()) {
      while (cnt[c - 'a']-- > 0) {
        sb.append(c);
      }
    }
    for (char c = 'a'; c <= 'z'; c++) {
      while (cnt[c - 'a']-- > 0) {
        sb.append(c);
      }
    }
    return sb.toString();
  }
}
