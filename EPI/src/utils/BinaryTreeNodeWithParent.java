package utils;

import java.util.*;

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

    public BinaryTreeNodeWithParent left() {
        return this._left;
    }

    public BinaryTreeNodeWithParent right() {
        return this._right;
    }

    public BinaryTreeNodeWithParent parent() {
        return this._parent;
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

    public BinaryTreeNodeWithParent inOrderSuccessor() {
        BinaryTreeNodeWithParent n = this;
        if (n._right != null) return n._right.leftMost();
        if (n.isLeftChild()) return n._parent;
        while (n.isRightChild() && n._parent != null) n = n._parent;
        return n._parent;
    }

    public BinaryTreeNodeWithParent preOrderSuccessor() {
        BinaryTreeNodeWithParent n = this;
        if (n._left != null) return n._left;
        if (n._right != null) return n._right;
        while (n._parent != null) {
            if (n.isLeftChild() && n._parent._right != null)
                return n._parent._right;
            n = n._parent;
        }
        return null;
    }

    public BinaryTreeNodeWithParent postOrderPredecessor() {
        BinaryTreeNodeWithParent n = this;
        if (n._right != null) return n._right;
        if (n._left != null) return n._left;
        while (n._parent != null) {
            if (n.isRightChild() && n._parent._left != null)
                return n._parent._left;
            n = n._parent;
        }
        return null;
    }

    public List<BinaryTreeNodeWithParent> preOrder() {
        List<BinaryTreeNodeWithParent> ls = new ArrayList<>();
        BinaryTreeNodeWithParent n = this;
        while (n != null) {
            ls.add(n);
            n = n.preOrderSuccessor();
        }
        return ls;
    }

    public List<BinaryTreeNodeWithParent> postOrder() {
        List<BinaryTreeNodeWithParent> ls = new ArrayList<>();
        BinaryTreeNodeWithParent n = this;
        while (n != null) {
            ls.add(n);
            n = n.postOrderPredecessor();
        }
        Collections.reverse(ls);
        return ls;
    }

    public List<BinaryTreeNodeWithParent> inOrder() {
        List<BinaryTreeNodeWithParent> ls = new ArrayList<>();
        BinaryTreeNodeWithParent n = this.leftMost();
        while (n != null) {
            ls.add(n);
            n = n.inOrderSuccessor();
        }
        return ls;
    }

    public int val() {
        return _val;
    }

    /**
     * Time : O(max(d1,d2))
     * Space : O(1)
     *
     * @param n1 node 1
     * @param n2 node 2
     * @return the lca of n1 and n2
     */
    public BinaryTreeNodeWithParent leastCommonAncestor(BinaryTreeNodeWithParent n1, BinaryTreeNodeWithParent n2) {
        int d1 = n1.depth();
        int d2 = n2.depth();
        int t = abs(d1 - d2);
        if (d1 > d2) while (t-- > 0) n1 = n1._parent;
        else while (t-- > 0) n2 = n2._parent;
        while (n1 != n2) {
            n1 = n1._parent;
            n2 = n2._parent;
        }
        return n1;
    }

    /**
     * Time: O(max(d(lca-n1),d(lca-n2))
     * Space: O(max(d(lca-n1),d(lca-n2))
     *
     * @param n1 node 1
     * @param n2 node 2
     * @return lca of n1 and n2
     */
    public BinaryTreeNodeWithParent leastCommonAncestorHashTable(BinaryTreeNodeWithParent n1, BinaryTreeNodeWithParent n2) {
        Set<BinaryTreeNodeWithParent> visited = new HashSet<>();
        while (n1 != null || n2 != null) {
            if (n1 != null) {
                if (!visited.add(n1)) return n1;
                n1 = n1._parent;
            }
            if (n2 != null) {
                if (!visited.add(n2)) return n2;
                n2 = n2._parent;
            }
        }
        return null;
    }

    public int depth() {
        BinaryTreeNodeWithParent n = this;
        int d = 0;
        while (n._parent != null) {
            d++;
            n = n._parent;
        }
        return d;
    }

    public int height() {
        int h = 0;
        if (isLeaf())
            return 0;
        if (left() != null)
            h = left().height();
        if (right() != null && right().height() > h)
            h = right().height();
        return 1 + h;
    }

    public boolean isLeaf() {
        return this._left == null && this._right == null;
    }
}
