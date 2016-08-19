/**
 * https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
 * Created by pankaj on 8/19/16.
 */
public class ConvertSortedArrayToBinarySearchTree {

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        return sortedArrayToBSTHelper(nums, 0, nums.length);
    }

    private TreeNode sortedArrayToBSTHelper(int[] nums, int begin, int end) {
        if (begin >= end) return null;
        int mid = (begin + end) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = sortedArrayToBSTHelper(nums, begin, mid);
        root.right = sortedArrayToBSTHelper(nums, mid + 1, end);
        return root;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
