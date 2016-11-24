/**
 * https://leetcode.com/problems/minimum-moves-to-equal-array-elements-ii/
 * Created by pankaj on 21/11/16.
 */
public class MinimumMovesToEqualArrayElementsII {
    public int minMoves2(int[] nums) {
        int N = nums.length;
        if (N == 0) return 0;
        int mid = nums[N / 2];
        int cnt = 0;
        for (int num : nums) cnt += Math.abs(mid - num);
        return cnt;
    }

    public int minMoves2Median(int[] nums) {
        int N = nums.length;
        if (N == 0) return 0;
        int mid = findMedian(nums);
        int cnt = 0;
        for (int num : nums) cnt += Math.abs(num - mid);
        return cnt;
    }

    public int findMedian(int[] A) {
        return findK(A, A.length / 2);
    }

    private int findK(int[] A, int k) {
        return findKHelper(A, 0, A.length - 1, k);
    }

    private int findKHelper(int[] A, int lo, int hi, int k) {
        int pivot = A[hi];
        int idx = lo, j = hi - 1;
        for (int i = lo; i < hi; i++) {
            if (A[i] < pivot) {
                swap(A, idx, i);
                idx++;
            }
        }
        swap(A, hi, idx);
        if (idx == k) return A[idx];
        else if (idx > k) return findKHelper(A, lo, idx - 1, k);
        else return findKHelper(A, idx + 1, hi, k);
    }

    private void swap(int[] A, int i, int j) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }
}
