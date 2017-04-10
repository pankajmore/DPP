/** https://leetcode.com/problems/next-greater-element-iii/ Created by pankaj on 10/04/17. */
public class NextGreaterElementIII {
  public int nextGreaterElement(int n) {
    char[] A = String.valueOf(n).toCharArray();
    int N = A.length, i = N - 2;
    while (i >= 0) {
      if (A[i] < A[i + 1]) {
        break;
      }
      --i;
    }
    if (i == -1) return -1;
    int j = N - 1;
    while (j >= 0) {
      if (A[j] > A[i]) {
        break;
      }
      --j;
    }
    char tmp = A[i];
    A[i] = A[j];
    A[j] = tmp;
    j = N - 1;
    ++i;
    while (i < j) {
      tmp = A[i];
      A[i] = A[j];
      A[j] = tmp;
      ++i;
      --j;
    }
    try {
      return Integer.parseInt(new String(A));
    } catch (Exception e) {
      return -1;
    }
  }
}
