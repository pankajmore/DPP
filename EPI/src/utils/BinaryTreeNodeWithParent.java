package utils;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.max;
import static java.lang.Math.abs;

/**
 * Created by Pankaj on 6/28/15.
 */
public class BinaryTreeNodeWithParent {

    private int _val;
    private BinaryTreeNodeWithParent _parent;
    private BinaryTreeNodeWithParent _left;
    private BinaryTreeNodeWithParent _right;

    public BinaryTreeNodeWithParent(BinaryTreeNode t) {
        if (t.left() != null) {
            this._left = new BinaryTreeNodeWithParent(t.left());
            this._left._parent = this;
        }
        if (t.right() != null) {
            this._right = new BinaryTreeNodeWithParent(t.right());
            this._right._parent = this;
        }
        this._val = t.val();
    }

    public BinaryTreeNodeWithParent(int val, BinaryTreeNodeWithParent left, BinaryTreeNodeWithParent right) {
        this._val = val;
        this._left = left;
        this._right = right;
        this._parent = null;
        _left._parent = this;
        _right._parent = this;
    }

    public BinaryTreeNodeWithParent leftMost() {
        BinaryTreeNodeWithParent n = this;
        while (n._left != null) n = n._left;
        return n;
    }

    public Boolean isLeftChild() {
        return this._parent != null && this._parent._left != null && this._parent._left.equals(this);
    }

    public Boolean isRightChild() {
        return !isLeftChild();
    }

    public BinaryTreeNodeWithParent successor() {
        BinaryTreeNodeWithParent n = this;
        if (n._right != null) return n._right.leftMost();
        if (n.isLeftChild()) return n._parent;
        else {
            while (n.isRightChild() && n._parent != null) n = n._parent;
            return n._parent;
        }
    }

    //TODO: Implement preOrder and postOrder in O(1) space
    public List<BinaryTreeNodeWithParent> inOrder() {
        List<BinaryTreeNodeWithParent> ls = new ArrayList<>();
        BinaryTreeNodeWithParent n = this.leftMost();
        while (n != null) {
            ls.add(n);
            n = n.successor();
        }
        return ls;
    }

    public int val() {
        return _val;
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

    public int height() {
        if (_left == null && _right == null) return 0;
        else if (_left == null) return 1 + _right.height();
        else return 1 + max(_left.height(), _right.height());
    }
}
