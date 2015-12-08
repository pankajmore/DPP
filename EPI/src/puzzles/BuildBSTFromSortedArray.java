package puzzles;

import utils.BinaryTreeNode;

/**
 * Created by Pankaj on 12/8/15.
 */
public class BuildBSTFromSortedArray {
    /**
     * Time: O(n)
     * Space: O(log(n))
     *
     * @param A sorted array of keys of a BST
     * @return the BST with minimum height corresponding to A as its inOrder sequence
     */
    public static BinaryTreeNode buildBSTFromSortedArray(Integer[] A) {
        return buildBSTFromSortedArrayHelper(A, 0, A.length - 1);
    }

    private static BinaryTreeNode buildBSTFromSortedArrayHelper(Integer[] A, int i, int j) {
        if (i > j) return null;
        int mid = i + (j - i) / 2;
        return new BinaryTreeNode(A[mid], buildBSTFromSortedArrayHelper(A, i, mid - 1),
                buildBSTFromSortedArrayHelper(A, mid + 1, j));
    }
}
