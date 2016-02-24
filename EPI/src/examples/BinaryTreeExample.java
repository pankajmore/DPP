package examples;

import utils.BinaryTreeNode;

/**
 * Created by Pankaj on 8/6/15.
 */
public class BinaryTreeExample {
    public static BinaryTreeNode constructBookExample() {
        BinaryTreeNode l = new BinaryTreeNode(6, new BinaryTreeNode(271, new BinaryTreeNode(28, null, null), new BinaryTreeNode(0, null, null)), new BinaryTreeNode(561, null, new BinaryTreeNode(3, new BinaryTreeNode(17, null, null), null)));
        BinaryTreeNode r = new BinaryTreeNode(6, new BinaryTreeNode(2, null, new BinaryTreeNode(1, new BinaryTreeNode(401, null, new BinaryTreeNode(641, null, null)), new BinaryTreeNode(257, null, null))), new BinaryTreeNode(271, null, new BinaryTreeNode(28, null, null)));
        BinaryTreeNode root = new BinaryTreeNode(314, l, r);
        return root;
    }

    public static BinaryTreeNode constructBSTExample() {
        BinaryTreeNode l = new BinaryTreeNode(7, new BinaryTreeNode(3, new BinaryTreeNode(2, null, null), new BinaryTreeNode(5, null, null)), new BinaryTreeNode(11, null, new BinaryTreeNode(17, new BinaryTreeNode(13, null, null), null)));
        BinaryTreeNode r = new BinaryTreeNode(43, new BinaryTreeNode(23, null, new BinaryTreeNode(37, new BinaryTreeNode(29, null, new BinaryTreeNode(31, null, null)), new BinaryTreeNode(41, null, null))), new BinaryTreeNode(47, null, new BinaryTreeNode(53, null, null)));
        BinaryTreeNode root = new BinaryTreeNode(19, l, r);
        return root;
    }

    public static BinaryTreeNode symmetricTree() {
        return new BinaryTreeNode(314, new BinaryTreeNode(6, null, new BinaryTreeNode(2, null, new BinaryTreeNode(3, null, null))), new BinaryTreeNode(6, new BinaryTreeNode(2, new BinaryTreeNode(3, null, null), null), null));
    }

    public static BinaryTreeNode almostBST() {
        return new BinaryTreeNode(17, new BinaryTreeNode(41, null, new BinaryTreeNode(8, new BinaryTreeNode(6, null, null), null)),
                new BinaryTreeNode(23, new BinaryTreeNode(21, null, null), new BinaryTreeNode(5, new BinaryTreeNode(30, null, null), null)));
    }
}
