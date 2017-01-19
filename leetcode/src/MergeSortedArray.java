/**
 * https://leetcode.com/problems/merge-sorted-array/
 * Created by pankaj on 19/01/17.
 */
public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = m - 1, j = n - 1; j >= 0; ) {
            nums1[i + j + 1] = i >= 0 && nums1[i] > nums2[j] ? nums1[i--] : nums2[j--];
        }
    }
}
