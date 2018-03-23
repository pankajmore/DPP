package dailycodingproblem;

/**
 * Given an array of numbers, find the length of the longest increasing subsequence in the array.
 * The subsequence does not necessarily have to be contiguous.
 */
class DCP75 {
  static int longesIncreasingSubsequence(int[] in) {
    if (in == null || in.length == 0) {
      return 0;
    }
    int[] longest = new int[in.length];
    int max = 1;
    for (int i = 0; i < in.length; i++) {
      longest[i] = 1;
      for (int j = 0; j < i; j++) {
        if (in[j] < in[i] && longest[j] + 1 > longest[i]) {
          longest[i] = longest[j] + 1;
        }
      }
      max = Math.max(max, longest[i]);
    }
    return max;
  }
}
