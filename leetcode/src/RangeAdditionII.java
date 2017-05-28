/** https://leetcode.com/problems/range-addition-ii/ Created by pankaj on 28/05/17. */
class RangeAdditionII {
  int maxCount(final int m, final int n, final int[][] ops) {
    int minA = m, minB = n;
    for (int[] op : ops) {
      minA = Math.min(minA, op[0]);
      minB = Math.min(minB, op[1]);
    }
    return minA * minB;
  }
}
