/** https://leetcode.com/problems/maximum-product-of-word-lengths/ Created by pankaj on 01/05/17. */
class MaximumProductOfWordLengths {
  int maxProduct(final String[] words) {
    int n = words.length;
    int[] wordMap = new int[n];
    for (int i = 0; i < n; i++) {
      for (char c : words[i].toCharArray()) {
        wordMap[i] = wordMap[i] | (1 << (c - 'a'));
      }
    }
    int max = 0;
    for (int i = 0; i < n; i++) {
      for (int j = i + 1; j < n; j++) {
        if ((wordMap[i] & wordMap[j]) == 0) {
          max = Math.max(max, words[i].length() * words[j].length());
        }
      }
    }
    return max;
  }
}
