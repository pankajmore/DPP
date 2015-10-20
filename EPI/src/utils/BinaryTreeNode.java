package utils;

import java.util.*;

import static java.lang.Math.abs;

/**
 * Created by Pankaj on 6/12/15.
 */
public class BinaryTreeNode {
    private int _val;
    private BinaryTreeNode _left;
    private BinaryTreeNode _right;

    public BinaryTreeNode(int val, BinaryTreeNode left, BinaryTreeNode right) {
        this._val = val;
        this._left = left;
        this._right = right;
    }

    public BinaryTreeNode(BinaryTreeNode other) throws Exception {
        if (other == null) throw new Exception("Cannot copy a null tree!");
        this._val = other._val;
        if (other._left != null) this._left = new BinaryTreeNode(other._left);
        if (other._right != null) this._right = new BinaryTreeNode(other._right);
    }

    public static BinaryTreeNode construct(List<Integer> inOrder, List<Integer> otherOrder) throws Exception {
        Map<Integer, Integer> nodeToIndex = new HashMap<>();
        for (int i = 0; i < inOrder.size(); i++)
            nodeToIndex.put(inOrder.get(i), i);
        if (inOrder.get(0).equals(otherOrder.get(0))) //postOrder
            return constructFromInOrderAndPostOrder(otherOrder, 0, otherOrder.size(), 0, inOrder.size(), nodeToIndex);
        return constructFromInOrderAndPreOrder(otherOrder, 0, otherOrder.size(), 0, inOrder.size(), nodeToIndex);
    }

    private static BinaryTreeNode constructFromInOrderAndPostOrder(List<Integer> postOrder, Integer postOrderStart, Integer postOrderEnd,
                                                                   Integer inOrderStart, Integer inOrderEnd,
                                                                   Map<Integer, Integer> nodeToIndex) throws Exception {
        if (inOrderEnd <= inOrderStart || postOrderEnd <= postOrderStart) return null;
        BinaryTreeNode root = new BinaryTreeNode(postOrder.get(postOrderEnd - 1), null, null);
        Integer rootPosition = nodeToIndex.get(root._val);
        if (rootPosition == null) throw new Exception("Cannot find the root in the inOrder list");
        Integer leftSubtreeSize = rootPosition - inOrderStart;
        root._left = constructFromInOrderAndPostOrder(postOrder, postOrderStart, postOrderStart + leftSubtreeSize, inOrderStart, rootPosition, nodeToIndex);
        root._right = constructFromInOrderAndPostOrder(postOrder, postOrderStart + leftSubtreeSize, postOrderEnd - 1, rootPosition + 1, inOrderEnd, nodeToIndex);
        return root;
    }

    private static BinaryTreeNode constructFromInOrderAndPreOrder(List<Integer> preOrder, Integer preOrderStart, Integer preOrderEnd,
                                                                  Integer inOrderStart, Integer inOrderEnd,
                                                                  Map<Integer, Integer> nodeToIndex) throws Exception {
        if (inOrderEnd <= inOrderStart || preOrderEnd <= preOrderStart) return null;
        Integer rootPosition = nodeToIndex.get(preOrder.get(preOrderStart));
        if (rootPosition == null) throw new Exception("Cannot find the root in the inOrder list");
        Integer leftSubTreeSize = rootPosition - inOrderStart;
        BinaryTreeNode root = new BinaryTreeNode(preOrder.get(preOrderStart), null, null);
        root._left = constructFromInOrderAndPreOrder(preOrder, preOrderStart + 1, preOrderStart + 1 + leftSubTreeSize, inOrderStart, rootPosition, nodeToIndex);
        root._right = constructFromInOrderAndPreOrder(preOrder, preOrderStart + 1 + leftSubTreeSize, preOrderEnd, rootPosition + 1, inOrderEnd, nodeToIndex);
        return root;
    }

    public int val() {
        return _val;
    }

    public BinaryTreeNode left() {
        return _left;
    }

    public BinaryTreeNode right() {
        return _right;
    }

    public boolean isLeaf() {
        return left() == null && right() == null;
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

    public boolean isBalancedSlow() {
        if (left() == null && right() == null) {
            return true;
        } else if (left() == null) {
            return right().height() <= 1;
        } else if (right() == null) {
            return left().height() <= 1;
        } else {
            boolean res;
            res = Math.abs(left().height() - right().height()) <= 1;
            res &= left().isBalancedSlow();
            res &= right().isBalancedSlow();
            return res;
        }
    }

    public BinaryTreeNode min() {
        BinaryTreeNode m = this;
        if (this.left() != null && this.left().min().val() < m.val())
            m = this.left().min();
        if (this.right() != null && this.right().min().val() < m.val())
            m = this.right().min();
        return m;
    }

    public BinaryTreeNode max() {
        BinaryTreeNode m = this;
        if (this.left() != null && this.left().max().val() > m.val())
            m = this.left().max();
        if (this.right() != null && this.right().max().val() > m.val())
            m = this.right().max();
        return m;
    }

    public boolean isBalanced() {
        return heightBalanced() != -2;
    }

    private int heightBalanced() {
        if (isLeaf()) return 0;
        int l_height, r_height;
        l_height = left() == null ? -1 : left().heightBalanced();
        if (l_height == -2) return -2;
        r_height = right() == null ? -1 : right().heightBalanced();
        if (r_height == -2) return -2;
        if (abs(l_height - r_height) > 1) return -2;
        return 1 + Math.max(l_height, r_height);
    }

    public List<BinaryTreeNode> inOrder() {
        List<BinaryTreeNode> ls = new ArrayList<>();
        if (this.left() != null)
            ls.addAll(this.left().inOrder());
        ls.add(this);
        if (this.right() != null)
            ls.addAll(this.right().inOrder());
        return ls;
    }

    public List<Integer> inOrderVals() {
        List<Integer> vals = new ArrayList<>();
        if (this.left() != null)
            vals.addAll(this.left().inOrderVals());
        vals.add(this.val());
        if (this.right() != null)
            vals.addAll(this.right().inOrderVals());
        return vals;
    }

    //TODO: implement morris traversal
    public List<BinaryTreeNode> inOrderMorris() {
        return inOrder();
    }

    public List<Integer> preOrder() {
        List<Integer> vals = new ArrayList<Integer>();
        vals.add(this.val());
        if (this.left() != null)
            vals.addAll(this.left().preOrder());
        if (this.right() != null)
            vals.addAll(this.right().preOrder());
        return vals;
    }

    public List<Integer> postOrder() {
        List<Integer> vals = new ArrayList<Integer>();
        if (this.left() != null)
            vals.addAll(this.left().postOrder());
        if (this.right() != null)
            vals.addAll(this.right().postOrder());
        vals.add(this.val());
        return vals;
    }

    public List<Integer> levelOrder() {
        List<Integer> vals = new ArrayList<Integer>();
        Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
        q.add(this);
        while (!q.isEmpty()) {
            BinaryTreeNode node = q.remove();
            vals.add(node.val());
            if (node.left() != null)
                q.add(node.left());
            if (node.right() != null)
                q.add(node.right());
        }
        return vals;
    }

    /**
     * @return List of list of nodes at each level by depth
     */
    public List<List<Integer>> levelOrderByDepth() {
        List<List<Integer>> ls = new ArrayList<List<Integer>>();
        Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
        q.add(this);
        int numNodesCurrLevel = 0, numNodesPrevLevel = 0;
        numNodesPrevLevel++;
        while (!q.isEmpty()) {
            List<Integer> currDepth = new ArrayList<Integer>();
            while (numNodesPrevLevel > 0 && !q.isEmpty()) {
                BinaryTreeNode node = q.remove();
                numNodesPrevLevel--;
                currDepth.add(node.val());
                if (node.left() != null) {
                    q.add(node.left());
                    numNodesCurrLevel++;
                }
                if (node.right() != null) {
                    q.add(node.right());
                    numNodesCurrLevel++;
                }
            }
            numNodesPrevLevel = numNodesCurrLevel;
            numNodesCurrLevel = 0;
            ls.add(currDepth);
        }
        return ls;
    }

    public boolean isBinarySearchTree() {
        boolean ok = true;
        if (this.left() != null)
            ok &= this.left().max().val() <= this.val() && this.left().isBinarySearchTree();
        if (this.right() != null)
            ok &= this.right().min().val() >= this.val() && this.right().isBinarySearchTree();
        return ok;
    }

    public boolean isBST() {
        return isBSTPostOrderImpl().second();
    }

    public Pair<Integer, Boolean> isBSTInOrderImpl() {
        if (this.left() != null) {
            Pair<Integer, Boolean> l = this.left().isBSTInOrderImpl();
            if (l.first() > this.val() || !l.second()) return new Pair<>(0, false);
        }
        if (this.right() != null) {
            Pair<Integer, Boolean> r = this.right().isBSTInOrderImpl();
            if (r.first() < this.val() || !r.second()) return new Pair<>(0, false);
        }
        return new Pair<>(this.val(), true);
    }

    public Pair<Pair<Integer, Integer>, Boolean> isBSTPostOrderImpl() {
        int min = this._val, max = this._val;
        if (this.left() != null) {
            Pair<Pair<Integer, Integer>, Boolean> l = this.left().isBSTPostOrderImpl();
            if (!l.second() || this.val() < l.first().second()) return new Pair<>(new Pair<>(0, 0), false);
            min = min > l.first().first() ? l.first().first() : min;
            max = max < l.first().second() ? l.first().second() : max;
        }
        if (this.right() != null) {
            Pair<Pair<Integer, Integer>, Boolean> r = this.right().isBSTPostOrderImpl();
            if (!r.second() || this.val() > r.first().first()) return new Pair<>(new Pair<>(0, 0), false);
            min = min > r.first().first() ? r.first().first() : min;
            max = max < r.first().second() ? r.first().second() : max;
        }
        return new Pair<>(new Pair<>(min, max), true);
    }

    public boolean isBSTRange() {
        return isBSTRangeImpl(Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public boolean isBSTRangeImpl(int min, int max) {
        if (this.val() < min || this.val() > max) return false;
        if (this.left() != null && !this.left().isBSTRangeImpl(min, this._val)) return false;
        if (this.right() != null && !this.right().isBSTRangeImpl(this._val, max)) return false;
        return true;
    }

    public BinaryTreeNode successor(int k) {
        return successorInOrderImpl(k);
    }

    private BinaryTreeNode successorInOrderImpl(int k) {
        Iterator<BinaryTreeNode> iter = this.inOrder().iterator();
        while (iter.hasNext()) {
            if (iter.next().val() == k) return iter.hasNext() ? iter.next() : null;
        }
        return null;
    }

    //TODO: there is a bug in here
    public Pair<Boolean, BinaryTreeNode> successorImpl(int k) {
        if (this.left() != null) {
            Pair<Boolean, BinaryTreeNode> l = this.left().successorImpl(k);
            if (l.first()) return new Pair<>(true, this);
        }
        if (this.val() == k) return new Pair<>(true, null);
        if (this.val() > k) return new Pair<>(false, null);
        if (this.right() != null) {
            Pair<Boolean, BinaryTreeNode> r = this.right().successorImpl(k);
            if (r.first()) return r;
        }
        return new Pair<>(false, null);
    }

    public boolean isSymmetric() throws Exception {
        if (this._left == null)
            return this._right == null;
        BinaryTreeNode left = new BinaryTreeNode(this.left());
        left.invert();
        return left.equals(this._right);
    }

    public void invert() {
        if (this._left != null) this._left.invert();
        if (this._right != null) this._right.invert();
        BinaryTreeNode temp = this._left;
        this._left = this._right;
        this._right = temp;
    }

    /**
     * This must be a distinct binary search tree.
     *
     * @param x a node in this BST
     * @param y another node in this BST
     *          assume x.val() < y.val(), x and y are in the bST
     * @return least common ancestor of x & y
     */
    public BinaryTreeNode leastCommonAncestorDistinctBST(BinaryTreeNode x, BinaryTreeNode y) {
        BinaryTreeNode t = this;
        while (t.val() < x.val() || t.val() > y.val()) {
            while (t.val() < x.val()) t = t.right();
            while (t.val() > y.val()) t = t.left();
        }
        return t;
    }

    public boolean equals(Object other) {
        if (other == null) return false;
        if (!(other instanceof BinaryTreeNode)) return false;
        BinaryTreeNode btOther = (BinaryTreeNode) other;
        boolean ok;
        ok = (this._val == btOther._val);
        if (this._left != null)
            ok &= this._left.equals(btOther._left);
        if (this._right != null)
            ok &= this._right.equals(btOther._right);
        return ok;
    }
}

