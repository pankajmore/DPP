package utils;

import java.util.ArrayList;
import java.util.List;

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

}
