package puzzles;

import utils.BinaryTreeNode;

import java.util.List;

/**
 * Created by Pankaj on 12/6/15.
 */
public class RebuildBSTPreOrder {
    static int i;
    /**
     * Builds a BST given its preOrder traversal.
     * Assumes that the keys in the BST are unique.
     * If the keys are not unique, there exist multiple BSTs that correspond to the same preOrder sequence
     * Time : O(n^2)
     * Space : O(n)
     *
     * @param preOrderSequence List of keys in preOrder traversal of a BST
     * @return the BST
     */
    public static BinaryTreeNode rebuildBSTFromPreOrder(List<Integer> preOrderSequence) {
        if (preOrderSequence.isEmpty()) return null;
        int i;
        for (i = 0; i < preOrderSequence.size(); i++) if (preOrderSequence.get(i) > preOrderSequence.get(0)) break;
        return new BinaryTreeNode(preOrderSequence.get(0), rebuildBSTFromPreOrder(preOrderSequence.subList(1, i)),
                rebuildBSTFromPreOrder(preOrderSequence.subList(i, preOrderSequence.size())));
    }

    /**
     * Time : O(n)
     * Space : O(n)
     *
     * @param preOrderSequence list of keys in preOrder traversal of a BST
     * @return the BST
     */
    public static BinaryTreeNode rebuildBSTFromPreOrderFast(List<Integer> preOrderSequence) {
        i = 0;
        return rebuildBSTFromPreOrderFastHelper(preOrderSequence, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static BinaryTreeNode rebuildBSTFromPreOrderFastHelper(List<Integer> preOrderSequence, int minValue, int maxValue) {
        if (i == preOrderSequence.size()) return null;
        int val = preOrderSequence.get(i);
        if (val < minValue || val > maxValue) return null;
        ++i;
        return new BinaryTreeNode(val, rebuildBSTFromPreOrderFastHelper(preOrderSequence, minValue, val),
                rebuildBSTFromPreOrderFastHelper(preOrderSequence, val, maxValue));
    }
}
