package utils;

/**
 * Created by Pankaj on 7/30/15.
 */
public class BinaryTreeNodeWithMinAndMax {
    private int _val;
    private BinaryTreeNodeWithMinAndMax _left;
    private BinaryTreeNodeWithMinAndMax _right;
    private BinaryTreeNodeWithMinAndMax _min;
    private BinaryTreeNodeWithMinAndMax _max;

    public BinaryTreeNodeWithMinAndMax(int val, BinaryTreeNodeWithMinAndMax left, BinaryTreeNodeWithMinAndMax right) {
        this._val = val;
        this._left = left;
        this._right = right;
        _min = _max = this;
        if (left != null) {
            if (this.left().min().val() < _min.val())
                _min = this.left().min();
            if (this.left().max().val() > _max.val())
                _max = this.left().max();
        }
        if (right != null) {
            if (this.right().min().val() < _min.val())
                _min = this.right().min();
            if (this.right().max().val() > _max.val())
                _max = this.right().max();
        }
    }

    private int val() {
        return _val;
    }

    public BinaryTreeNodeWithMinAndMax min() {
        return _min;
    }

    public BinaryTreeNodeWithMinAndMax max() {
        return _max;
    }

    public BinaryTreeNodeWithMinAndMax right() {
        return _right;
    }

    public BinaryTreeNodeWithMinAndMax left() {
        return _left;
    }

    public boolean isBinarySearchTree() {
        boolean ok = true;
        if (this.left() != null)
            ok &= this.left().max().val() <= this.val() && this.left().isBinarySearchTree();
        if (this.right() != null)
            ok &= this.right().min().val() >= this.val() && this.right().isBinarySearchTree();
        return ok;
    }
}
