package puzzles;

import utils.BinaryTreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by pankaj on 2/22/16.
 */
public class ConnectLeavesBinaryTree {
    /**
     * Time : O(N)
     * Space : O(H)
     *
     * @param root a binary tree of size N and height H
     * @return create a list of leaves of root
     */
    public static List<BinaryTreeNode> createListOfLeaves(BinaryTreeNode root) {
        List<BinaryTreeNode> list = new LinkedList<>();
        createListOfLeavesHelper(root, list);
        return list;
    }

    private static void createListOfLeavesHelper(BinaryTreeNode root, List<BinaryTreeNode> list) {
        if (root == null) return;
        if (root.left == null && root.right == null) list.add(root);
        createListOfLeavesHelper(root.left, list);
        createListOfLeavesHelper(root.right, list);
    }


}
