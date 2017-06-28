/** https://leetcode.com/problems/unique-binary-search-trees/ Created by pankaj on 28/06/17. */
class UniqueBinarySearchTrees {
  int numTrees(final int n) {
    int[] numTrees = new int[n + 1];
    numTrees[0] = 1;
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= i; j++) {
        numTrees[i] += numTrees[j - 1] * numTrees[i - j];
      }
    }
    return numTrees[n];
  }
}
