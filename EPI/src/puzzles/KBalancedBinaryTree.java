package puzzles;

import utils.BinaryTreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by pankaj on 2/14/16.
 */
public class KBalancedBinaryTree {
    private Map<BinaryTreeNode, Integer> _size;
    private Map<BinaryTreeNode, Boolean> _balanced;

    public KBalancedBinaryTree() {
        _size = new HashMap<>();
        _balanced = new HashMap<>();
    }

    public BinaryTreeNode kUnbalancedBinaryTree(BinaryTreeNode root, int k) {
        if (root == null) return null;
        if (kBalanced(root.left, k) && kBalanced(root.right, k) && !kBalanced(root, k)) return root;
        BinaryTreeNode left = kUnbalancedBinaryTree(root.left, k);
        if (left != null) return left;
        return kUnbalancedBinaryTree(root.right, k);
    }

    public boolean kBalanced(BinaryTreeNode root, int k) {
        if (root == null) return true;
        if (!_balanced.containsKey(root))
            _balanced.put(root, kBalanced(root.left, k) && kBalanced(root.right, k)
                    && Math.abs(size(root.left) - size(root.right)) <= k);
        return _balanced.get(root);
    }

    public int size(BinaryTreeNode root) {
        if (root == null) return 0;
        if (!_size.containsKey(root))
            _size.put(root, 1 + size(root.left) + size(root.right));
        return _size.get(root);
    }
}
