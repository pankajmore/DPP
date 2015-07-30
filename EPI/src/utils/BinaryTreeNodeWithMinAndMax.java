package utils;

/**
 * Created by Pankaj on 7/30/15.
 */
public class BinaryTreeNodeWithMinAndMax extends BinaryTreeNode {
    private BinaryTreeNodeWithMinAndMax _left;
    private BinaryTreeNodeWithMinAndMax _right;
    private BinaryTreeNodeWithMinAndMax _min;
    private BinaryTreeNodeWithMinAndMax _max;

    public BinaryTreeNodeWithMinAndMax(int val, BinaryTreeNodeWithMinAndMax left, BinaryTreeNodeWithMinAndMax right) {
        super(val, left, right);
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
}
