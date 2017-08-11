/** https://leetcode.com/problems/range-addition Created by pankaj on 11/08/17. */
class RangeAddition {
  int[] getModifiedArray(final int length, final int[][] updates) {
    int[] arr = new int[length];
    for (int[] update : updates) {
      int start = update[0];
      int end = update[1];
      int inc = update[2];
      arr[start] += inc;
      if (end + 1 != length) {
        arr[end + 1] -= inc;
      }
    }
    for (int i = 1; i < length; i++) {
      arr[i] += arr[i - 1];
    }
    return arr;
  }
}
