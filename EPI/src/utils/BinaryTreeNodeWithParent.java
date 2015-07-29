package utils;

import java.util.List;

import static java.lang.Math.abs;

/**
 * Created by Pankaj on 6/28/15.
 */
public class BinaryTreeNodeWithParent extends BinaryTreeNode {
    /**
     * Pointer to the parent node of this
     */
    private BinaryTreeNodeWithParent _parent;

    public BinaryTreeNodeWithParent(int val, BinaryTreeNodeWithParent left, BinaryTreeNodeWithParent right) {
        super(val, left, right);
        this._parent = null;
        left._parent = this;
        right._parent = this;
    }

    @Override
    public List<Integer> inOrder() {
        return super.inOrder(); // TODO: make it use O(1) space
    }

    @Override
    public List<Integer> preOrder() {
        return super.preOrder();
    }

    @Override
    public List<Integer> postOrder() {
        return super.postOrder();
    }

    public BinaryTreeNodeWithParent leastCommonAncestor(BinaryTreeNodeWithParent n1, BinaryTreeNodeWithParent n2) {
        int h1 = n1.height();
        int h2 = n2.height();
        int t = abs(h1 - h2);
        if (h1 > h2) while (t-- > 0) n1 = n1._parent;
        else while (t-- > 0) n2 = n2._parent;
        while (n1 != n2) {
            n1 = n1._parent;
            n2 = n2._parent;
        }
        return n1;
    }
}
